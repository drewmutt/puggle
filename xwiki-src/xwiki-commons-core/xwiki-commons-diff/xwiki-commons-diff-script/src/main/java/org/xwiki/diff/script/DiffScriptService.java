/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.diff.script;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.context.Execution;
import org.xwiki.diff.DiffConfiguration;
import org.xwiki.diff.DiffException;
import org.xwiki.diff.DiffManager;
import org.xwiki.diff.DiffResult;
import org.xwiki.diff.MergeConfiguration;
import org.xwiki.diff.MergeException;
import org.xwiki.diff.MergeResult;
import org.xwiki.diff.internal.DefaultDiffResult;
import org.xwiki.diff.internal.DefaultMergeResult;
import org.xwiki.script.service.ScriptService;

/**
 * Provide script oriented APIs to do diff and merges.
 *
 * @version $Id: caeaf8756568b9c4bfbf6bf1676afdc586ca957a $
 * @since 4.1RC1
 */
@Component
@Named("diff")
@Singleton
public class DiffScriptService implements ScriptService
{
    /**
     * The key under which the last encountered error is stored in the current execution context.
     */
    static final String DIFF_ERROR_KEY = "scriptservice.diff.error";

    /**
     * The component used to access the execution context.
     */
    @Inject
    private Execution execution;

    /**
     * The component used to create the diff.
     */
    @Inject
    private DiffManager diffManager;

    /**
     * The displayer oriented sub API.
     */
    @Inject
    @Named("diff.display")
    private ScriptService diffDisplayScriptService;

    /**
     * @return the display oriented API
     */
    public ScriptService getDisplay()
    {
        return this.diffDisplayScriptService;
    }

    /**
     * Produce a diff between the two provided versions.
     *
     * @param <E> the type of compared elements
     * @param previous the previous version of the content to compare
     * @param next the next version of the content to compare
     * @param configuration the configuration of the diff behavior
     * @return the result of the diff
     */
    public <E> DiffResult<E> diff(List<E> previous, List<E> next, DiffConfiguration<E> configuration)
    {
        DiffResult<E> result;
        try {
            result = this.diffManager.diff(previous, next, configuration);
        } catch (DiffException e) {
            result = new DefaultDiffResult<E>(previous, next);
            result.getLog().error("Failed to execute diff", e);
        }

        return result;
    }

    /**
     * Execute a 3-way merge on provided versions.
     *
     * @param <E> the type of compared elements
     * @param commonAncestor the common ancestor of the two versions of the content to compare
     * @param next the next version of the content to compare
     * @param current the current version of the content to compare
     * @param configuration the configuration of the merge behavior
     * @return the result of the merge
     */
    public <E> MergeResult<E> merge(List<E> commonAncestor, List<E> next, List<E> current,
        MergeConfiguration<E> configuration)
    {
        MergeResult<E> result;
        try {
            result = this.diffManager.merge(commonAncestor, next, current, configuration);
        } catch (MergeException e) {
            result = new DefaultMergeResult<E>(commonAncestor, next, current);
            result.getLog().error("Failed to execute merge", e);
        }

        return result;
    }

    /**
     * Get the error generated while performing the previously called action.
     *
     * @return an eventual exception or {@code null} if no exception was thrown
     */
    public Exception getLastError()
    {
        return (Exception) this.execution.getContext().getProperty(DIFF_ERROR_KEY);
    }
}
