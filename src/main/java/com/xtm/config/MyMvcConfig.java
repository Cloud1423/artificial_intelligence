package com.xtm.config;

import com.xtm.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 拦截器
 * */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /*
    * 添加拦截器
    * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")//指定拦截器要拦截的请求,拦截任意多层路径下的任何请求，访问当前项目的任何资源，"classpath:/META-INF/resources/" "classpath:/resources/" "classpath:/static/" "classpath:/public/" "/"(当前项目根路径) 以上是静态资源文件夹在java文件夹下
                .excludePathPatterns("/", "/defaultKaptcha", "/loginResource/**", "/asserts/**", "/admin/login", "/swagger-ui.html#", "/front/**");//设置不拦截的请求
    }



    /*
    * 只进行页面的跳转，不涉及任何业务逻辑的处理，只是单纯的路由跳转过程或者是点击一个按钮跳转到另一个页面。
    * 可以使用下面的方法
    *   registry.addViewController("/index").setViewName("index");相当于：
    *           @RequestMapping("/index")
    *            public String index(){
    *              return "index";
    *           }
    * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/detail.html").setViewName("detail");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/article.html").setViewName("article/newArticle");
        registry.addViewController("/listArticle.html").setViewName("article/listArticle");
        registry.addViewController("/news.html").setViewName("news/publishNews");
        registry.addViewController("/listNews.html").setViewName("news/listNews");
        registry.addViewController("/profile.html").setViewName("admin/profile");
        registry.addViewController("/messages.html").setViewName("message/listMessage");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/test.html").setViewName("news/test");
        registry.addViewController("/addType.html").setViewName("news/addType");
        registry.addViewController("/detailNews.html").setViewName("news/detailNews");
        registry.addViewController("/list.html").setViewName("list");
    }
}
