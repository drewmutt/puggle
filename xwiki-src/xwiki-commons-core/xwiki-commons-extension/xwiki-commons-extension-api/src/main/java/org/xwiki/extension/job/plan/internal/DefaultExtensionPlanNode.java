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
package org.xwiki.extension.job.plan.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

import org.xwiki.extension.job.plan.ExtensionPlanAction;
import org.xwiki.extension.job.plan.ExtensionPlanNode;
import org.xwiki.extension.version.VersionConstraint;

/**
 * A node in the extension plan tree.
 *
 * @version $Id: e06d8d9b0067e74226db90888418f3b59dc64a6b $
 * @since 4.0M1
 */
public class DefaultExtensionPlanNode implements ExtensionPlanNode, Cloneable
{
    /**
     * @see #getAction()
     */
    protected ExtensionPlanAction action;

    /**
     * @see #getChildren()
     */
    protected Collection<ExtensionPlanNode> children;

    /**
     * @see #getInitialVersionConstraint()
     */
    protected VersionConstraint initialVersionConstraint;

    /**
     * Default constructor.
     */
    public DefaultExtensionPlanNode()
    {

    }

    /**
     * @param node a node to copy
     */
    public DefaultExtensionPlanNode(ExtensionPlanNode node)
    {
        this(node.getAction(), node.getChildren(), node.getInitialVersionConstraint());
    }

    /**
     * @param action the action to perform for this node
     * @param initialVersionConstraint the initial version constraint before resolving the extension
     */
    public DefaultExtensionPlanNode(ExtensionPlanAction action, VersionConstraint initialVersionConstraint)
    {
        this(action, null, initialVersionConstraint);
    }

    /**
     * @param action the action to perform for this node
     * @param children the children of this node
     * @param initialVersionConstraint the initial version constraint before resolving the extension
     */
    public DefaultExtensionPlanNode(ExtensionPlanAction action, Collection<ExtensionPlanNode> children,
        VersionConstraint initialVersionConstraint)
    {
        this.action = action;
        if (children != null) {
            this.children = new CopyOnWriteArrayList<>(children);
        } else {
            this.children = Collections.emptyList();
        }
        this.initialVersionConstraint = initialVersionConstraint;
    }

    @Override
    protected DefaultExtensionPlanNode clone()
    {
        try {
            return (DefaultExtensionPlanNode) super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }

    @Override
    public ExtensionPlanAction getAction()
    {
        return this.action;
    }

    @Override
    public Collection<ExtensionPlanNode> getChildren()
    {
        return this.children != null ? this.children : Collections.<ExtensionPlanNode>emptyList();
    }

    @Override
    public VersionConstraint getInitialVersionConstraint()
    {
        return this.initialVersionConstraint;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(getAction());
        builder.append(" (");
        builder.append(getChildren());
        if (getInitialVersionConstraint() != null) {
            builder.append(", ");
            builder.append(getInitialVersionConstraint());
        }
        builder.append(')');

        return builder.toString();
    }
}
