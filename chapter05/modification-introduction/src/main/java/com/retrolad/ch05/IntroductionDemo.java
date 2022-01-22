package com.retrolad.ch05;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionDemo {
    public static void main(String[] args) {

        Contract target = new Contract();

        Advisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        Contract proxy = (Contract) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.println("Is Contract?: " + (proxy instanceof Contract));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Max Verstappen");

        System.out.println("Has been modified?:" + proxyInterface.isModified());

        proxy.setName("Lando Norris");

        System.out.println("Has been modified?:" + proxyInterface.isModified());
    }
}
