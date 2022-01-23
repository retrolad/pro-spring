package com.retrolad.ch05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("config")
@ComponentScan(basePackages = {"com.retrolad.ch05"})
@EnableAspectJAutoProxy(proxyTargetClass = true) // <aop:aspectj-autoproxy/> for XML
public class AppConfig {
}
