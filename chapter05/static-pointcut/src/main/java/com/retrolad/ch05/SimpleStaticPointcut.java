package com.retrolad.ch05;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    // We want this pointcut be applied to methods named 'sing'
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "sing".equals(method.getName());
    }

    // We want this pointcut be only applied to method in GreatGuitarist class
    @Override
    public ClassFilter getClassFilter() {
        return cls -> cls == GreatGuitarist.class;
    }
}
