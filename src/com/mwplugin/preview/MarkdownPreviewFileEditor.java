package com.mwplugin.preview;

import com.intellij.CommonBundle;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Alarm;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.util.ui.JBUI;
import com.mwplugin.preview.javafx.JavaFxHtmlPanelProvider;
import com.mwplugin.wikiconversion.WikiParser;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class MarkdownPreviewFileEditor extends UserDataHolderBase implements FileEditor {
  private final static long PARSING_CALL_TIMEOUT_MS = 50L;

  private final static long RENDERING_DELAY_MS = 20L;
  @NotNull
  private final JPanel myHtmlPanelWrapper;
  @NotNull
  private MarkdownHtmlPanel myPanel;
  @Nullable
  private MarkdownHtmlPanelProvider.ProviderInfo myLastPanelProviderInfo = null;
  @NotNull
  private final VirtualFile myFile;
  @Nullable
  private final Document myDocument;
  @NotNull
  private final Alarm myPooledAlarm = new Alarm(Alarm.ThreadToUse.POOLED_THREAD, this);
  @NotNull
  private final Alarm mySwingAlarm = new Alarm(Alarm.ThreadToUse.SWING_THREAD, this);

  private final Object REQUESTS_LOCK = new Object();
  @Nullable
  private Runnable myLastScrollRequest = null;
  @Nullable
  private Runnable myLastHtmlOrRefreshRequest = null;

  private volatile int myLastScrollOffset;
  @NotNull
  private String myLastRenderedHtml = "";

  public MarkdownPreviewFileEditor(@NotNull VirtualFile file) {
    myFile = file;
    myDocument = FileDocumentManager.getInstance().getDocument(myFile);

    if (myDocument != null) {
      myDocument.addDocumentListener(new DocumentAdapter() {

        @Override
        public void beforeDocumentChange(DocumentEvent e) {
          myPooledAlarm.cancelAllRequests();
        }

        @Override
        public void documentChanged(final DocumentEvent e) {
          myPooledAlarm.addRequest(() -> {
            //myLastScrollOffset = e.getOffset();
            updateHtml(true);
          }, PARSING_CALL_TIMEOUT_MS);
        }
      }, this);
    }

    myHtmlPanelWrapper = new JPanel(new BorderLayout());

//    final MarkdownApplicationSettings settings = MarkdownApplicationSettings.getInstance();
    myPanel = detachOldPanelAndCreateAndAttachNewOne(myHtmlPanelWrapper, null, new JavaFxHtmlPanelProvider());
//    updatePanelCssSettings(myPanel, settings.getMarkdownCssSettings());

//    MessageBusConnection settingsConnection = ApplicationManager.getApplication().getMessageBus().connect(this);
//    MarkdownApplicationSettings.SettingsChangedListener settingsChangedListener = new MyUpdatePanelOnSettingsChangedListener();
//    settingsConnection.subscribe(MarkdownApplicationSettings.SettingsChangedListener.TOPIC, settingsChangedListener);
  }

  public void scrollToSrcOffset(final int offset) {
    // Do not scroll if html update request is online
    // This will restrain preview from glitches on editing
    if (!myPooledAlarm.isEmpty()) {
      myLastScrollOffset = offset;
      return;
    }

    synchronized (REQUESTS_LOCK) {
      if (myLastScrollRequest != null) {
        mySwingAlarm.cancelRequest(myLastScrollRequest);
      }
      myLastScrollRequest = () -> {
        myLastScrollOffset = offset;
        myPanel.scrollToMarkdownSrcOffset(myLastScrollOffset);
        synchronized (REQUESTS_LOCK) {
          myLastScrollRequest = null;
        }
      };
      mySwingAlarm.addRequest(myLastScrollRequest, RENDERING_DELAY_MS, ModalityState.stateForComponent(getComponent()));
    }
  }


  @NotNull
  public JComponent getComponent()
  {
    return myHtmlPanelWrapper;
  }

  @Nullable
  public JComponent getPreferredFocusedComponent()
  {
    return myHtmlPanelWrapper;
  }

  @NotNull
  public String getName()
  {
    return "WM File Editor";
  }

  @NotNull
  @Override
  public FileEditorState getState(@NotNull FileEditorStateLevel level)
  {
    return FileEditorState.INSTANCE;
  }


  public void setState(@NotNull FileEditorState state)
  {

  }

  public boolean isModified()
  {
    return false;
  }

  public boolean isValid()
  {
    return false;
  }

  @Override
  public void selectNotify() {
    myPooledAlarm.cancelAllRequests();
    myPooledAlarm.addRequest(() -> updateHtml(true), 0);
  }

  static public JavaFxHtmlPanelProvider panelProvider = new JavaFxHtmlPanelProvider();


  @Nullable("Null means leave current panel")
  private MarkdownHtmlPanelProvider retrievePanelProvider(@NotNull MarkdownApplicationSettings settings) {
  /*
    final MarkdownHtmlPanelProvider.ProviderInfo providerInfo = panelProvider.getProviderInfo();
    if (providerInfo.equals(myLastPanelProviderInfo)) {
      return null;
    }
*/
//    MarkdownHtmlPanelProvider provider = MarkdownHtmlPanelProvider.createFromInfo(providerInfo);
/*
    if (provider.isAvailable() != MarkdownHtmlPanelProvider.AvailabilityInfo.AVAILABLE) {
      settings.setMarkdownPreviewSettings(new MarkdownPreviewSettings(settings.getMarkdownPreviewSettings().getSplitEditorLayout(),
                                                                      MarkdownPreviewSettings.DEFAULT.getHtmlPanelProviderInfo(),
                                                                      settings.getMarkdownPreviewSettings().isUseGrayscaleRendering()));

      Messages.showMessageDialog(
        myHtmlPanelWrapper,
        "Tried to use preview panel provider (" + providerInfo.getName() + "), but it is unavailable. Reverting to default.",
        CommonBundle.getErrorTitle(),
        Messages.getErrorIcon()
      );

      provider = MarkdownHtmlPanelProvider.getProviders()[0];
    }
*/
//    myLastPanelProviderInfo = settings.getMarkdownPreviewSettings().getHtmlPanelProviderInfo();
    return panelProvider;
  }

  /**
   * Is always run from pooled thread
   */
  private void updateHtml(final boolean preserveScrollOffset) {
    if (!myFile.isValid() || myDocument == null || Disposer.isDisposed(this)) {
      return;
    }

    String wiki = myDocument.getText();
    String html = null;
    WikiParser parser = new WikiParser();
    html = parser.renderWikiText(wiki, "Dude");
    // EA-75860: The lines to the top may be processed slowly; Since we're in pooled thread, we can be disposed already.
    if (!myFile.isValid() || Disposer.isDisposed(this)) {
      return;
    }

    synchronized (REQUESTS_LOCK) {
      if (myLastHtmlOrRefreshRequest != null) {
        mySwingAlarm.cancelRequest(myLastHtmlOrRefreshRequest);
      }
      String finalHtml = html;
      myLastHtmlOrRefreshRequest = () -> {

        String currentHtml = finalHtml;
        System.out.println(finalHtml);
        if (!currentHtml.equals(myLastRenderedHtml)) {
          myLastRenderedHtml = currentHtml;
          myPanel.setHtml(myLastRenderedHtml);

          if (preserveScrollOffset) {
            myPanel.scrollToMarkdownSrcOffset(myLastScrollOffset);
          }
        }

        myPanel.render();
        synchronized (REQUESTS_LOCK) {
          myLastHtmlOrRefreshRequest = null;
        }
      };
      mySwingAlarm.addRequest(myLastHtmlOrRefreshRequest, RENDERING_DELAY_MS, ModalityState.stateForComponent(getComponent()));
    }
  }

  @Override
  public void deselectNotify() {
  }

  @Override
  public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {
  }

  @Override
  public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {
  }

  @Nullable
  @Override
  public BackgroundEditorHighlighter getBackgroundHighlighter() {
    return null;
  }

  @Nullable
  @Override
  public FileEditorLocation getCurrentLocation() {
    return null;
  }

  @Nullable
  @Override
  public StructureViewBuilder getStructureViewBuilder() {
    return null;
  }

  @Override
  public void dispose() {
    Disposer.dispose(myPanel);
  }

  @NotNull
  private static String generateMarkdownHtml(@NotNull VirtualFile file, @NotNull String text) {
    final VirtualFile parent = file.getParent();
    final URI baseUri = parent != null ? new File(parent.getPath()).toURI() : null;
/*
    final ASTNode parsedTree = new MarkdownParser(MarkdownParserManager.FLAVOUR).buildMarkdownTreeFromString(text);
    final Map<IElementType, GeneratingProvider> htmlGeneratingProviders =
      MarkdownParserManager.FLAVOUR.createHtmlGeneratingProviders(LinkMap.Builder.buildLinkMap(parsedTree, text), baseUri);

  */  return text; //return new HtmlGenerator(text, parsedTree, htmlGeneratingProviders, true).generateHtml();
  }

  @Contract("_, null, null -> fail")
  @NotNull
  private static MarkdownHtmlPanel detachOldPanelAndCreateAndAttachNewOne(@NotNull JPanel panelWrapper,
                                                                          @Nullable MarkdownHtmlPanel oldPanel,
                                                                          @Nullable MarkdownHtmlPanelProvider newPanelProvider) {
    ApplicationManager.getApplication().assertIsDispatchThread();
    if (oldPanel == null && newPanelProvider == null) {
      throw new IllegalArgumentException("Either create new one or leave the old");
    }
    if (newPanelProvider == null) {
      return oldPanel;
    }
    if (oldPanel != null) {
      panelWrapper.remove(oldPanel.getComponent());
      Disposer.dispose(oldPanel);
    }

    final MarkdownHtmlPanel newPanel = newPanelProvider.createHtmlPanel();
    panelWrapper.add(newPanel.getComponent(), BorderLayout.CENTER);
    panelWrapper.repaint();

    return newPanel;
  }

  private static void updatePanelCssSettings(@NotNull MarkdownHtmlPanel panel, @NotNull final MarkdownCssSettings cssSettings) {
    ApplicationManager.getApplication().assertIsDispatchThread();
    //noinspection StringBufferReplaceableByString
    final String inlineCss = new StringBuilder()
//      .append(cssSettings.isTextEnabled() ? cssSettings.getStylesheetText() + "\n" : "")
      .append("body {\n  font-size: ").append(JBUI.scale(100)).append("%;\n}")
      .toString();

//    panel.setCSS(inlineCss, cssSettings.isUriEnabled() ? cssSettings.getStylesheetUri() : null);
    panel.render();
  }



  private class MyUpdatePanelOnSettingsChangedListener implements MarkdownApplicationSettings.SettingsChangedListener {
    public void onSettingsChange(@NotNull MarkdownApplicationSettings settings) {
      final MarkdownHtmlPanelProvider newPanelProvider = retrievePanelProvider(settings);

      mySwingAlarm.addRequest(() -> {
        myPanel = detachOldPanelAndCreateAndAttachNewOne(myHtmlPanelWrapper, myPanel, newPanelProvider);
        myPanel.setHtml(myLastRenderedHtml);
        updatePanelCssSettings(myPanel, settings.getMarkdownCssSettings());
      }, 0, ModalityState.stateForComponent(getComponent()));
    }
  }
}