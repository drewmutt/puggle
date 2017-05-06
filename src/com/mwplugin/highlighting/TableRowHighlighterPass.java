package com.mwplugin.highlighting;

import com.intellij.codeHighlighting.TextEditorHighlightingPass;
import com.intellij.codeInsight.TargetElementUtil;
import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.codeInsight.daemon.impl.UpdateHighlightersUtil;
import com.intellij.codeInsight.highlighting.HighlightHandlerBase;
import com.intellij.codeInsight.highlighting.HighlightUsagesHandler;
import com.intellij.codeInsight.highlighting.HighlightUsagesHandlerBase;
import com.intellij.codeInsight.highlighting.ReadWriteAccessDetector;
import com.intellij.find.FindManager;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesManager;
import com.intellij.find.impl.FindManagerImpl;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.impl.DocumentMarkupModel;
import com.intellij.openapi.editor.markup.MarkupModel;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.IndexNotReadyException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Couple;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.injected.InjectedLanguageUtil;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.containers.ContainerUtil;
import com.mwplugin.psi.MediaWikiTable;
import com.mwplugin.psi.MediaWikiTableBlock;
import com.mwplugin.psi.MediaWikiTableCell;
import com.mwplugin.psi.MediaWikiTableRow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Created by andrewsimmons on 5/5/17.
 */
public class TableRowHighlighterPass extends TextEditorHighlightingPass
{


	private final PsiFile myFile;
	private final Editor myEditor;
	private final int myCaretOffset;
	private final ArrayList<TextRange> myRanges = new ArrayList<>();

	TableRowHighlighterPass(@NotNull Project project, @NotNull PsiFile file, @NotNull Editor editor) {
		super(project, editor.getDocument(), false);
		myFile = file;
		myEditor = editor;
		myCaretOffset = myEditor.getCaretModel().getOffset();
	}

	@Override
	public void doCollectInformation(@NotNull ProgressIndicator progress)
	{

		PsiElement element = myFile.findElementAt(myEditor.getCaretModel().getOffset());
		MediaWikiTable table = PsiTreeUtil.getParentOfType(element, MediaWikiTable.class);
		if(table != null)
		{
				MediaWikiTableRow myRow = PsiTreeUtil.getParentOfType(element, MediaWikiTableRow.class);
				if(myRow != null)
				{
					MediaWikiTableBlock myBlock = PsiTreeUtil.getParentOfType(element, MediaWikiTableBlock.class);
					int childNumber = -1;
					List<MediaWikiTableRow> childTableCells = PsiTreeUtil.getChildrenOfAnyType(myBlock, MediaWikiTableRow.class);
					childNumber = childTableCells.indexOf(myRow);

					MediaWikiTableBlock[] allBlocks = PsiTreeUtil.getChildrenOfType(table, MediaWikiTableBlock.class);
					for (int i = 0; i < allBlocks.length; i++)
					{
						MediaWikiTableBlock block = allBlocks[i];
						List<MediaWikiTableRow> blockChildren = PsiTreeUtil.getChildrenOfAnyType(block, MediaWikiTableRow.class);
						if (blockChildren.size() > childNumber)
						{
							PsiElement blockChild = blockChildren.get(childNumber);
							TextRange range = new TextRange(blockChild.getTextRange().getStartOffset()+1, blockChild.getTextRange().getEndOffset());
							myRanges.add(range);
						}
					}
				}
		}

	}

	@Override
	public void doApplyInformationToEditor()
	{
		Collection<HighlightInfo> infos = getHighlights();
		UpdateHighlightersUtil.setHighlightersToEditor(myProject, myDocument, 0, myFile.getTextLength(), infos, getColorsScheme(), getId());
	}


	private List<HighlightInfo> getHighlights() {
		Set<Pair<Object, TextRange>> existingMarkupTooltips = new HashSet<>();
		for (RangeHighlighter highlighter : myEditor.getMarkupModel().getAllHighlighters()) {
			existingMarkupTooltips.add(Pair.create(highlighter.getErrorStripeTooltip(), new TextRange(highlighter.getStartOffset(), highlighter.getEndOffset())));
		}

		List<HighlightInfo> result = new ArrayList<>();
		for(TextRange range:myRanges)
			ContainerUtil.addIfNotNull(result, createHighlightInfo(range, HighlightInfoType.ELEMENT_UNDER_CARET_READ, existingMarkupTooltips));

		return result;
	}

	private HighlightInfo createHighlightInfo(TextRange range, HighlightInfoType type, Set<Pair<Object, TextRange>> existingMarkupTooltips) {
		int start = range.getStartOffset();
		String tooltip = start <= myDocument.getTextLength() ? HighlightHandlerBase.getLineTextErrorStripeTooltip(myDocument, start, false) : null;
		String unescapedTooltip = existingMarkupTooltips.contains(new Pair<Object, TextRange>(tooltip, range)) ? null : tooltip;
		HighlightInfo.Builder builder = HighlightInfo.newHighlightInfo(type).range(range);
		if (unescapedTooltip != null) {
			builder.unescapedToolTip(unescapedTooltip);
		}
		return builder.createUnconditionally();
	}


	/*
		private static final Logger LOG = Logger.getInstance("#com.intellij.codeInsight.daemon.impl.IdentifierHighlighterPass");

		private final PsiFile myFile;
		private final Editor myEditor;
		private final Collection<TextRange> myReadAccessRanges = Collections.synchronizedList(new ArrayList<TextRange>());
		private final Collection<TextRange> myWriteAccessRanges = Collections.synchronizedList(new ArrayList<TextRange>());
		private final int myCaretOffset;
		private final HighlightUsagesHandlerBase<PsiElement> myHighlightUsagesHandler;

		TableRowHighlighterPass(@NotNull Project project, @NotNull PsiFile file, @NotNull Editor editor) {
			super(project, editor.getDocument(), false);
			myFile = file;
			myEditor = editor;
			myCaretOffset = myEditor.getCaretModel().getOffset();
			myHighlightUsagesHandler = HighlightUsagesHandler.createCustomHandler(myEditor, myFile);
		}

		@Override
		public void doCollectInformation(@NotNull final ProgressIndicator progress) {
			if (myHighlightUsagesHandler != null) {
				List<PsiElement> targets = myHighlightUsagesHandler.getTargets();
				myHighlightUsagesHandler.computeUsages(targets);
				final List<TextRange> readUsages = myHighlightUsagesHandler.getReadUsages();
				for (TextRange readUsage : readUsages) {
					LOG.assertTrue(readUsage != null, "null text range from " + myHighlightUsagesHandler);
				}
				myReadAccessRanges.addAll(readUsages);
				final List<TextRange> writeUsages = myHighlightUsagesHandler.getWriteUsages();
				for (TextRange writeUsage : writeUsages) {
					LOG.assertTrue(writeUsage != null, "null text range from " + myHighlightUsagesHandler);
				}
				myWriteAccessRanges.addAll(writeUsages);
				if (!myHighlightUsagesHandler.highlightReferences()) return;
			}

			int flags = TargetElementUtil.ELEMENT_NAME_ACCEPTED | TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED;
			PsiElement myTarget;
			try {
				myTarget = TargetElementUtil.getInstance().findTargetElement(myEditor, flags, myCaretOffset);
			}
			catch (IndexNotReadyException e) {
				return;
			}

			if (myTarget == null) {
				if (!PsiDocumentManager.getInstance(myProject).isUncommited(myEditor.getDocument())) {
					// when document is committed, try to check injected stuff - it's fast
					Editor injectedEditor = InjectedLanguageUtil.getEditorForInjectedLanguageNoCommit(myEditor, myFile, myCaretOffset);
					myTarget = TargetElementUtil.getInstance().findTargetElement(injectedEditor, flags, injectedEditor.getCaretModel().getOffset());
				}
			}

			if (myTarget != null) {
				highlightTargetUsages(myTarget);
			} else {
				PsiReference ref = TargetElementUtil.findReference(myEditor);
				if (ref instanceof PsiPolyVariantReference) {
					if (!ref.getElement().isValid()) {
						throw new PsiInvalidElementAccessException(ref.getElement(), "Invalid element in " + ref + " of " + ref.getClass() + "; editor=" + myEditor);
					}
					ResolveResult[] results = ((PsiPolyVariantReference)ref).multiResolve(false);
					if (results.length > 0) {
						for (ResolveResult result : results) {
							PsiElement target = result.getElement();
							if (target != null) {
								if (!target.isValid()) {
									throw new PsiInvalidElementAccessException(target, "Invalid element returned from " + ref + " of " + ref.getClass() + "; editor=" + myEditor);
								}
								highlightTargetUsages(target);
							}
						}
					}
				}

			}
		}

		*
		 * Returns read and write usages of psi element inside a single element
		 *
		 * @param target target psi element
		 * @param psiElement psi element to search in
		 * @return a pair where first element is read usages and second is write usages

		@NotNull
		public static Couple<Collection<TextRange>> getHighlightUsages(@NotNull PsiElement target, PsiElement psiElement, boolean withDeclarations) {
			return getUsages(target, psiElement, withDeclarations, true);
		}


		 * Returns usages of psi element inside a single element
		 *
		 * @param target target psi element
		 * @param psiElement psi element to search in

		@NotNull
		public static Collection<TextRange> getUsages(@NotNull PsiElement target, PsiElement psiElement, boolean withDeclarations) {
			return getUsages(target, psiElement, withDeclarations, false).first;
		}

		@NotNull
		private static Couple<Collection<TextRange>> getUsages(@NotNull PsiElement target, PsiElement psiElement, boolean withDeclarations, boolean detectAccess) {
			List<TextRange> readRanges = new ArrayList<>();
			List<TextRange> writeRanges = new ArrayList<>();
			final ReadWriteAccessDetector detector = detectAccess ? ReadWriteAccessDetector.findDetector(target) : null;
			final FindUsagesManager findUsagesManager = ((FindManagerImpl) FindManager.getInstance(target.getProject())).getFindUsagesManager();
			final FindUsagesHandler findUsagesHandler = findUsagesManager.getFindUsagesHandler(target, true);
			final LocalSearchScope scope = new LocalSearchScope(psiElement);
			Collection<PsiReference> refs = findUsagesHandler != null
					? findUsagesHandler.findReferencesToHighlight(target, scope)
					: ReferencesSearch.search(target, scope).findAll();
			for (PsiReference psiReference : refs) {
				if (psiReference == null) {
					LOG.error("Null reference returned, findUsagesHandler=" + findUsagesHandler + "; target=" + target + " of " + target.getClass());
					continue;
				}
				List<TextRange> destination;
				if (detector == null || detector.getReferenceAccess(target, psiReference) == ReadWriteAccessDetector.Access.Read) {
					destination = readRanges;
				}
				else {
					destination = writeRanges;
				}
				HighlightUsagesHandler.collectRangesToHighlight(psiReference, destination);
			}

			if (withDeclarations) {
				final TextRange declRange = HighlightUsagesHandler.getNameIdentifierRange(psiElement.getContainingFile(), target);
				if (declRange != null) {
					if (detector != null && detector.isDeclarationWriteAccess(target)) {
						writeRanges.add(declRange);
					}
					else {
						readRanges.add(declRange);
					}
				}
			}

			return Couple.<Collection<TextRange>>of(readRanges, writeRanges);
		}

		private void highlightTargetUsages(@NotNull PsiElement target) {
			final Couple<Collection<TextRange>> usages = getHighlightUsages(target, myFile, true);
			myReadAccessRanges.addAll(usages.first);
			myWriteAccessRanges.addAll(usages.second);
		}
	*/

/*
	@Override
	public void doApplyInformationToEditor() {
		final boolean virtSpace = TargetElementUtil.inVirtualSpace(myEditor, myEditor.getCaretModel().getOffset());
		final List<HighlightInfo> infos = virtSpace ? Collections.<HighlightInfo>emptyList() : getHighlights();

		UpdateHighlightersUtil.setHighlightersToEditor(myProject, myDocument, 0, myFile.getTextLength(), infos, getColorsScheme(), getId());
	}

	private List<HighlightInfo> getHighlights() {
		if (myReadAccessRanges.isEmpty() && myWriteAccessRanges.isEmpty()) {
			return Collections.emptyList();
		}
		Set<Pair<Object, TextRange>> existingMarkupTooltips = new HashSet<>();
		for (RangeHighlighter highlighter : myEditor.getMarkupModel().getAllHighlighters()) {
			existingMarkupTooltips.add(Pair.create(highlighter.getErrorStripeTooltip(), new TextRange(highlighter.getStartOffset(), highlighter.getEndOffset())));
		}

		List<HighlightInfo> result = new ArrayList<>(myReadAccessRanges.size() + myWriteAccessRanges.size());
		for (TextRange range: myReadAccessRanges) {
			ContainerUtil.addIfNotNull(result, createHighlightInfo(range, HighlightInfoType.ELEMENT_UNDER_CARET_READ, existingMarkupTooltips));
		}
		for (TextRange range: myWriteAccessRanges) {
			ContainerUtil.addIfNotNull(result, createHighlightInfo(range, HighlightInfoType.ELEMENT_UNDER_CARET_WRITE, existingMarkupTooltips));
		}
		return result;
	}

	private HighlightInfo createHighlightInfo(TextRange range, HighlightInfoType type, Set<Pair<Object, TextRange>> existingMarkupTooltips) {
		int start = range.getStartOffset();
		String tooltip = start <= myDocument.getTextLength() ? HighlightHandlerBase.getLineTextErrorStripeTooltip(myDocument, start, false) : null;
		String unescapedTooltip = existingMarkupTooltips.contains(new Pair<Object, TextRange>(tooltip, range)) ? null : tooltip;
		HighlightInfo.Builder builder = HighlightInfo.newHighlightInfo(type).range(range);
		if (unescapedTooltip != null) {
			builder.unescapedToolTip(unescapedTooltip);
		}
		return builder.createUnconditionally();
	}

	*/
}
