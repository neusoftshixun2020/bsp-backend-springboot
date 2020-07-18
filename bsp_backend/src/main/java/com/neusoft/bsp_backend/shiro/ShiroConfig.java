package com.neusoft.bsp_backend.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("userSecurityManager")DefaultWebSecurityManager userSecurityManager ) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(userSecurityManager);

        Map<String, String> filterMap = new LinkedHashMap<>();

       filterMap.put("/", "anon");
       filterMap.put("/user/checkUser", "anon");
        filterMap.put("/user/getInfo", "anon");
       filterMap.put("/user/login", "anon");
        filterMap.put("/user/addUser", "anon");
        filterMap.put("/user/getVerifyCode", "anon");
        filterMap.put("/user/getVerifyCodeNumber", "anon");
        filterMap.put("/permission/getAllRoles", "anon");

       filterMap.put("/swagger-ui.html", "anon");
       filterMap.put("/swagger-resources/**", "anon");
       filterMap.put("/v2/**", "anon");
       filterMap.put("/webjars/**", "anon");

       filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        Map<String, Filter> myfilterMap = shiroFilterFactoryBean.getFilters();
        myfilterMap.put("authc", new MyAuthenticationFilter());
        return shiroFilterFactoryBean;
    }

    @Bean(name="userSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

}
