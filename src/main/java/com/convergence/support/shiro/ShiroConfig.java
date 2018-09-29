package com.convergence.support.shiro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import com.convergence.domain.ResourceDTO;
import com.convergence.service.ResourceService;

@Configuration
@Import(ShiroManager.class)
public class ShiroConfig {
	@Resource
	private ResourceService resourceService;

	/*
	 * @Bean(name = "realm")
	 * 
	 * @DependsOn("lifecycleBeanPostProcessor")
	 * 
	 * @ConditionalOnMissingBean public Realm realm() { return new MyRealm(); }
	 */
	@Bean
	public Realm realm() {
		return new MyRealm();
	}

	/**
	 * 用户授权信息Cache
	 */
	@Bean
	public CacheManager cacheManager() {
		return new MemoryConstrainedCacheManager();
	}

	@Bean(name = "securityManager")
	@ConditionalOnMissingBean
	public DefaultSecurityManager securityManager() {
		DefaultSecurityManager sm = new DefaultWebSecurityManager();
		sm.setCacheManager(cacheManager());
		return sm;
	}

	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

		// logged in users with the 'admin' role
		// chainDefinition.addPathDefinition("/**", "authc, roles[admin]");

		// logged in users with the 'document:read' permission
		// chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");

		// all other paths require a logged in user
		// chainDefinition.addPathDefinition("/**", "authc");

		// 不需要在此处配置权限页面,因为ShiroFilterFactoryBean已经配置过,但是此处必须存在,因为shiro-spring-boot-web-starter或查找此Bean,没有会报错
		return chainDefinition;
	}

	@Bean(name = "shiroFilter")
	@DependsOn("securityManager")
	@ConditionalOnMissingBean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager securityManager, Realm realm) {

		securityManager.setRealm(realm);

		/*
		 * ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		 * shiroFilter.setSecurityManager(securityManager);
		 * shiroFilter.setLoginUrl("/admin/login");
		 * shiroFilter.setSuccessUrl("/admin/index");
		 * shiroFilter.setUnauthorizedUrl("/previlige/no"); Map<String, String>
		 * filterChainDefinitionMap = new HashMap<String, String>();
		 * filterChainDefinitionMap.put("/assets/**", "anon");
		 * 
		 * filterChainDefinitionMap.put("/admin/login", "anon");
		 * 
		 * filterChainDefinitionMap.put("/admin/user/index",
		 * "perms[system:user:index]"); filterChainDefinitionMap.put("/admin/user/add",
		 * "perms[system:user:add]"); filterChainDefinitionMap.put("/admin/user/edit*",
		 * "perms[system:user:edit]");
		 * filterChainDefinitionMap.put("/admin/user/deleteBatch",
		 * "perms[system:user:deleteBatch]");
		 * filterChainDefinitionMap.put("/admin/user/grant/**",
		 * "perms[system:user:grant]");
		 * 
		 * filterChainDefinitionMap.put("/admin/role/index",
		 * "perms[system:role:index]"); filterChainDefinitionMap.put("/admin/role/add",
		 * "perms[system:role:add]"); filterChainDefinitionMap.put("/admin/role/edit*",
		 * "perms[system:role:edit]");
		 * filterChainDefinitionMap.put("/admin/role/deleteBatch",
		 * "perms[system:role:deleteBatch]");
		 * filterChainDefinitionMap.put("/admin/role/grant/**",
		 * "perms[system:role:grant]");
		 * 
		 * filterChainDefinitionMap.put("/admin/resource/index",
		 * "perms[system:resource:index]");
		 * filterChainDefinitionMap.put("/admin/resource/add",
		 * "perms[system:resource:add]");
		 * filterChainDefinitionMap.put("/admin/resource/edit*",
		 * "perms[system:resource:edit]");
		 * filterChainDefinitionMap.put("/admin/resource/deleteBatch",
		 * "perms[system:resource:deleteBatch]");
		 * 
		 * filterChainDefinitionMap.put("/admin/**", "authc");
		 * shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
		 */
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		shiroFilter.setLoginUrl("/login");
		shiroFilter.setSuccessUrl("/index");
		shiroFilter.setUnauthorizedUrl("/privilege/no");
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/assets/**", "anon");
		filterChainDefinitionMap.put("/aop/**", "anon");

		filterChainDefinitionMap.put("/login", "anon");

		List<ResourceDTO> list = resourceService.findAllForShiro();
		if (CollectionUtils.isNotEmpty(list)) {
			for (ResourceDTO resource : list) {
				filterChainDefinitionMap.put(resource.getSourceUrl(), "perms[" + resource.getSourceKey() + "]");
			}
		}
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilter;
	}
}
