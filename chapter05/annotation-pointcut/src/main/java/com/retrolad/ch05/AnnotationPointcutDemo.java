package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutDemo {
    public static void main(String[] args) {

        Guitarist target = new Guitarist();
        Guitarist proxy;

        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut
                                                .forMethodAnnotation(AdviceRequired.class);

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        proxy = (Guitarist) pf.getProxy();

        proxy.sing();
        proxy.rest();
        proxy.sing(new Guitar());
    }
}
