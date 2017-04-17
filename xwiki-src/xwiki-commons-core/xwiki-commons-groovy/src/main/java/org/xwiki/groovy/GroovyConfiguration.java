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
package org.xwiki.groovy;

import java.util.List;

import org.codehaus.groovy.control.customizers.CompilationCustomizer;
import org.xwiki.component.annotation.Role;

/**
 * Configuration properties for the Groovy engine.
 *
 * @version $Id: ed46be9ea5ced12993a8a822a66fb7fb05805dab $
 * @since 4.1M1
 */
@Role
public interface GroovyConfiguration
{
    /**
     * @return the list of Customizer names classes to use when executing a Groovy script
     */
    List<String> getCompilationCustomizerNames();

    /**
     * @return the list of Customizer implementation classes to use when executing a Groovy script
     */
    List<CompilationCustomizer> getCompilationCustomizers();
}
