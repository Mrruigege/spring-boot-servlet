package com.rui.springbootservlet.configuration;

import com.rui.springbootservlet.filter.MyFilter;
import com.rui.springbootservlet.listener.MyListener;
import com.rui.springbootservlet.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ServletConfig {
    //servlet组件注册，加入到容器中
    @Bean
   public ServletRegistrationBean myServlet(){
       ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
       return registrationBean;
   }
   //Filter组件注册，加入到容器中
   @Bean
   public FilterRegistrationBean myFilter(){
       FilterRegistrationBean registrationBean = new FilterRegistrationBean();
       registrationBean.setFilter(new MyFilter());
       registrationBean.setUrlPatterns(Arrays.asList("/myservlet"));
       return registrationBean;
   }
   //Listener组件注册，加入到容器中
   @Bean
   public ServletListenerRegistrationBean myListener(){
       ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
       return  registrationBean;
   }
}
