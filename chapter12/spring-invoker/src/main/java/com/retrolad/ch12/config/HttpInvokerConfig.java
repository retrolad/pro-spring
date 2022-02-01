package com.retrolad.ch12.config;

import com.retrolad.ch12.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
public class HttpInvokerConfig {

    @Autowired
    private DeveloperService developerService;

    // Exports any bean component as a services via Spring HTTP
    @Bean(name = "/httpInvoker/developerService")
    public HttpInvokerServiceExporter httpInvokerServiceExporter() {
        HttpInvokerServiceExporter invokerService = new HttpInvokerServiceExporter();
        invokerService.setService(developerService);
        invokerService.setServiceInterface(DeveloperService.class);

        return invokerService;
    }
}
