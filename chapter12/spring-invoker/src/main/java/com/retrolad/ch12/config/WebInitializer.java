package com.retrolad.ch12.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// This class configures ServletContext
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DataServiceConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {HttpInvokerConfig.class, WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/invoker/*"};
    }
}
