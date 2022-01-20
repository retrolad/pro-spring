package com.retrolad.ch05;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class RegexPointcutDemo {
    public static void main(String[] args) {
        Guitarist target = new Guitarist();
        Guitarist proxy;

        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*sing.*");

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(pointcut, new SimpleAdvice()));
        pf.setTarget(target);

        proxy = (Guitarist) pf.getProxy();

        proxy.sing();
        proxy.rest();
        proxy.sing2();
    }
}
