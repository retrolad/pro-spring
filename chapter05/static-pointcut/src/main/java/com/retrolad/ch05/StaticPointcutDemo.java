package com.retrolad.ch05;

import com.retrolad.ch02.common.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public static void main(String[] args) {
        GoodGuitarist goodGuitarist = new GoodGuitarist();
        GreatGuitarist greatGuitarist = new GreatGuitarist();

        Singer proxy1;
        Singer proxy2;

        Pointcut pointcut = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        // Combines a pointcut and an advice
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory pf1 = new ProxyFactory();
        pf1.addAdvisor(advisor);
        pf1.setTarget(goodGuitarist);

        ProxyFactory pf2 = new ProxyFactory();
        pf2.addAdvisor(advisor);
        pf2.setTarget(greatGuitarist);

        proxy1 = (Singer) pf1.getProxy();
        proxy2 = (Singer) pf2.getProxy();

        proxy1.sing();
        proxy2.sing();
    }
}
