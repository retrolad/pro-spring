package com.retrolad.ch12.config;

import com.retrolad.ch12.services.DeveloperService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class RmiClientConfig {

    @Bean
    public DeveloperService developerService() {
        HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
        factoryBean.setServiceInterface(DeveloperService.class);
        factoryBean.setServiceUrl("http://localhost:8080/invoker/httpInvoker/developerService");
        factoryBean.afterPropertiesSet();

        return (DeveloperService) factoryBean.getObject();
    }
}
