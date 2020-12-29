package cn.chen.teachingsystem.conf;

import cn.chen.teachingsystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/4/4
 * Time: 23:53
 * Description: 应用程序配置类
 *
 * @author chen
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor getMyInterceptor() {
        return new LoginInterceptor();
    }

    /**
     * 多个拦截器组成一个拦截器链
     * addPathPatterns 用于添加拦截规则
     * excludePathPatterns 用户排除拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求
        registry.addInterceptor(getMyInterceptor())
                .addPathPatterns("/**")
                //排除的路径：静态资源路径。防止被JdkApiInterceptor拦截
                .excludePathPatterns("/login", "/swagger-ui/*", "/error/**", "/js/**", "/css/**", "/img/**",
                        "/swagger-resources/**", "/webjars/**", "/swagger-ui.html/**","/v3/**");
        ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        //swagger增加url映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

