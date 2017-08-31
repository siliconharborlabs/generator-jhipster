<%#
 Copyright 2013-2017 the original author or authors from the StackStack project.

 This file is part of the StackStack project, see http://www.jhipster.tech/
 for more information.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-%>
package <%=packageName%>.config;

import org.hibernate.cache.infinispan.InfinispanRegionFactory;
import org.hibernate.service.ServiceRegistry;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.cache.TransactionMode;
import org.infinispan.manager.EmbeddedCacheManager;

import java.util.Properties;

/**
 * Factory class for initializing Hibernate 2nd-level cache with Infinispan cache.
 *
 * <p>
 * This will be created through reflection. With Hibernate 5, support
 * to manage this cache through Spring has been removed and there is no way to inject it using
 * Dependency Injection. This needs to be initialized from
 * {@link CacheConfiguration#cacheConfigurer(io.github.jhipster.config.JHipsterProperties) CacheConfiguration } to keep the same cache manager
 * between the Spring Cache and Hibernate.
 */
public class CacheFactoryConfiguration extends InfinispanRegionFactory {

    /**
     * Defines an Hibernate L2 cache: hibernate-infinispan
     */
    @Override
    protected EmbeddedCacheManager createCacheManager(Properties properties, ServiceRegistry serviceRegistry) {
        // Not a managed bean from the Spring Context (as it gets created through reflection) and hence override the static instance
        return CacheConfiguration.getCacheManager();
    }

}
