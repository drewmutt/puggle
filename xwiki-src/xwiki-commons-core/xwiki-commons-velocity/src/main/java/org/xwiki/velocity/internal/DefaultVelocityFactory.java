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
package org.xwiki.velocity.internal;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.manager.ComponentLookupException;
import org.xwiki.component.manager.ComponentManager;
import org.xwiki.management.JMXBeanRegistration;
import org.xwiki.velocity.VelocityEngine;
import org.xwiki.velocity.VelocityFactory;
import org.xwiki.velocity.XWikiVelocityException;
import org.xwiki.velocity.internal.jmx.JMXVelocityEngine;
import org.xwiki.velocity.internal.jmx.JMXVelocityEngineMBean;

/**
 * Default implementation for {@link VelocityFactory}.
 *
 * @see VelocityFactory
 * @version $Id: 2cd41bff44faf49b18f86f220764e82620e97cb4 $
 */
@Component
@Singleton
public class DefaultVelocityFactory implements VelocityFactory
{
    private static final String MBEANNAME_PREFIX = "type=Velocity,domain=Engines,name=";

    /**
     * The Component manager we use to lookup (and thus create since it's a singleton) the VelocityEngine component.
     */
    @Inject
    private ComponentManager componentManager;

    /**
     * In order to register the Velocity MBean for management.
     */
    @Inject
    private JMXBeanRegistration jmxRegistration;

    /**
     * A cache of Velocity Engines. See {@link org.xwiki.velocity.VelocityFactory} for more details as to why we need
     * this cache.
     */
    private Map<String, VelocityEngine> velocityEngines = new ConcurrentHashMap<String, VelocityEngine>();

    @Override
    public boolean hasVelocityEngine(String key)
    {
        return this.velocityEngines.containsKey(key);
    }

    @Override
    public VelocityEngine getVelocityEngine(String key)
    {
        return this.velocityEngines.get(key);
    }

    @Override
    public VelocityEngine createVelocityEngine(String key, Properties properties) throws XWikiVelocityException
    {
        VelocityEngine engine;
        try {
            engine = this.componentManager.getInstance(VelocityEngine.class);
        } catch (ComponentLookupException e) {
            throw new XWikiVelocityException("Failed to create Velocity Engine", e);
        }
        engine.initialize(properties);
        this.velocityEngines.put(key, engine);

        // Register a JMX MBean for providing information about the created Velocity Engine (template namespaces,
        // macros, etc).
        JMXVelocityEngineMBean mbean = new JMXVelocityEngine(engine);
        this.jmxRegistration.registerMBean(mbean, MBEANNAME_PREFIX + key);

        return engine;
    }

    @Override
    public VelocityEngine removeVelocityEngine(String key)
    {
        this.jmxRegistration.unregisterMBean(MBEANNAME_PREFIX + key);

        return this.velocityEngines.remove(key);
    }
}
