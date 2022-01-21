package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class ComposablePointcutDemo {
    public static void main(String[] args) {

        GrammyGuitarist target = new GrammyGuitarist();

        ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());

        GrammyGuitarist proxy1 = getProxy(pointcut, target);

        System.out.println("> Test1:");
        testInvoke(proxy1);
        System.out.println();

        pointcut.union(new TalkMethodMatcher());
        GrammyGuitarist proxy2 = getProxy(pointcut, target);
        System.out.println("> Test2:");
        testInvoke(proxy2);
        System.out.println();

        pointcut.intersection(new RestMethodMatcher());
        GrammyGuitarist proxy3 = getProxy(pointcut, target);
        System.out.println("> Test3:");
        testInvoke(proxy3);
    }

    private static GrammyGuitarist getProxy(ComposablePointcut pc, GrammyGuitarist target) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice()));
        pf.setTarget(target);

        return (GrammyGuitarist) pf.getProxy();
    }

    private static void testInvoke(GrammyGuitarist proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();
    }

    private static class SingMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.getName().startsWith("si");
        }
    }

    private static class TalkMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return "talk".equals(method.getName());
        }
    }

    private static class RestMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.getName().endsWith("st");
        }
    }
}
