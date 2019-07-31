package com.gzdata.common.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
/**
 * @Description: 拦截器配置
 * @author: Yangxf
 * @date: 2019/4/14 13:09
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    
    /**
     * @Function: 这个方法才能在拦截器中自动注入查询数据库的对象
     * @author:   YangXueFeng
     * @Date:     2019/4/14 13:10
     */
    @Bean
    AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    
    /**
     * @Function: 配置生成器：添加一个拦截器，拦截路径为login以后的路径
     * @author:   YangXueFeng
     * @Date:     2019/4/14 13:10
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry ){
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**").excludePathPatterns("/rpc","/webjars","/swagger-ui.html","/login", "/register", "/static");
    }
 
}
