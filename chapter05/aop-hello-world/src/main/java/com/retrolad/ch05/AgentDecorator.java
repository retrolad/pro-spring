package com.retrolad.ch05;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * {@link MethodInterceptor} is a standard interface to implement
 * around advice for method invocation joinpoints.
 *
 * {@link MethodInvocation} represents the method invocation that
 * is being advised.
 */
public class AgentDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("James ");

        Object retVal = invocation.proceed();

        System.out.print("!");
        return retVal;
    }
}
