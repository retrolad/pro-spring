package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import javax.naming.Name;

public class NamePointcutDemo {
    public static void main(String[] args) {

        GrammyGuitarist target = new GrammyGuitarist();
        GrammyGuitarist proxy = null;

//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.addMethodName("sing");
//        pointcut.addMethodName("talk");
//        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.setMappedNames("sing");
        advisor.setMappedNames("talk");

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(target);

        proxy = (GrammyGuitarist) pf.getProxy();

        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}
