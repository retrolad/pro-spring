package com.retrolad.ch05;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    // This is used for static matching. Result is cached for further
    // calls. Checks if method matches.
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for '" + method.getName() + "'");
        return "foo".equals(method.getName());
    }

    // This is used for dynamic matching
    // Only gets called if 2 argument matches method returned true
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {

        System.out.println("Dynamic checking for '" + method.getName() + "'");
        return (Integer) args[0] != 100;
    }

    @Override
    public ClassFilter getClassFilter() {
        return cls -> cls == SampleBean.class;
    }
}
