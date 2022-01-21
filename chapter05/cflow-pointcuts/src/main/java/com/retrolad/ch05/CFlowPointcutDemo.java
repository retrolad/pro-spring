package com.retrolad.ch05;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class CFlowPointcutDemo {
    public static void main(String[] args) {

        TestBean target = new TestBean();
        TestBean proxy;

        // Pointcut matches all calls from test method
        ControlFlowPointcut pointcut = new ControlFlowPointcut(CFlowPointcutDemo.class, "test");
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice()));
        pf.setTarget(target);

        proxy = (TestBean) pf.getProxy();

        proxy.foo();
        new CFlowPointcutDemo().test(proxy);
    }

    public void test(TestBean testBean) {
        testBean.foo();
    }
}
