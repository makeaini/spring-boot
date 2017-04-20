package com.pppcar.spring.boot.cahce;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching // 标注启动缓存.
public class EHCacheConfig {

	/**
	 * 缓存管理器.
	 * 
	 * @param EhCacheCacheManager
	 * @return
	 */
	@Bean
	public EhCacheCacheManager cacheManager(EhCacheManagerFactoryBean ehCacheManagerFactoryBean) {
		return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		System.out.println("CacheConfiguration.ehCacheManagerFactoryBean()");
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}

}