package com.retrolad.ch05;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutDemo {
    public static void main(String[] args) {
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());

        SampleBean target = new SampleBean();
        SampleBean proxy;

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(target);

        proxy = (SampleBean) pf.getProxy();

        proxy.bar();
        proxy.foo(50);
        proxy.foo(100);
    }
}
