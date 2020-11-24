package com.cslg.system.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
	
	/**
	 * 创建ShiroFilterFactoryBean
	 */
	@Bean()
	public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//shiroFilterFactoryBean.setUnauthorizedUrl("/toCommonLogin");
		//未登录时跳转页面
		shiroFilterFactoryBean.setLoginUrl("/toCommonLogin");
		//添加shiro内置过滤器
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		filterMap.put("/","anon");    //放行首页
		filterMap.put("/css/**","anon");
		filterMap.put("/image/**","anon");
		filterMap.put("/js/**","anon");
		filterMap.put("/webjars/**","anon");
		filterMap.put("/X-admin/**","anon");
		filterMap.put("/favicon.ico","anon");
		filterMap.put("/toCommonLogin","anon");    //前台登录页面
		filterMap.put("/toCommonRegister","anon");    //前台注册页面
		filterMap.put("/commonLogin","anon");	//前台登录
		filterMap.put("/commonRegister","anon");	//前台注册
		filterMap.put("/commonLogout","logout");	//前台登出
		filterMap.put("/commonCourseSearch","anon");	//前台根据关键字搜索课程
		filterMap.put("/toCourseSearch*","anon");	//跳转到课程搜索页面
		filterMap.put("/commonCourseSearchData","anon");	//课程搜索拿到数据
		filterMap.put("/backend","anon");    //后台登录页面
		filterMap.put("/systemLogin","anon");    //后台登录
		filterMap.put("/checkUsername","anon");
		filterMap.put("/commonSelectCourseParents","anon");
		filterMap.put("/commonSelectCourseChildren","anon");
		filterMap.put("/toCourseVideo*","anon");    //视频播放页面
		filterMap.put("/files/**","anon");    //文件资源
		filterMap.put("/commonQueryLatestCourse","anon");    //首页查询最新课程
		filterMap.put("/commonQueryHottestCourse","anon");    //首页查询最热门课程
		filterMap.put("/commonQueryRecommendCourse","anon");    //首页查询站长推荐课程
		filterMap.put("/commonQueryCourseInfoToPage","anon");    //查询点击的课程信息
		filterMap.put("/commonQueryAllComments","anon");    //查询所有评论
		filterMap.put("/**","authc");    //拦截所有请求
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 创建DefaultWebSecurityManager
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//关联realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	
	/**
	 * 创建Realm
	 */
	@Bean(name="userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
	
	/**
     * 密码匹配凭证管理器
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

}
