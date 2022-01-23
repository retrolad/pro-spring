package com.retrolad.ch05;

import com.retrolad.ch02.common.Guitar;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// For XML
//<bean id="myAspect" class="com.retrolad.ch05.NotVeryUsefulAspect">
    //<!-- configure properties of the aspect here -->
//</bean>
@Component
@Aspect
public class AnnotatedAdvice {

    // Apply advice only to sing method joinpoint, that receive Guitar and pass that arg to
    // this pointcut
    @Pointcut("execution(* com.retrolad.ch05..sing*(com.retrolad.ch02.common.Guitar))" +
            " && args(value)")
    public void singExecution(Guitar value) {
    }

    // Apply advice only to beans, which name starts with "john"
    @Pointcut("bean(john*)")
    public void isJohn() {
    }

    @Before(value = "singExecution(value) && isJohn()", argNames = "joinPoint,value")
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
        if(value.getBrand().equals("Gibson")) {
            System.out.println("Executing: " + joinPoint.getSignature().getDeclaringType() +
                    " " + joinPoint.getSignature().getName() + " argument: " + value.getBrand());
        }
    }

    @Around("singExecution(value) && isJohn()")
    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar value) throws Throwable {
        System.out.println("Before executing: "
                + pjp.getSignature().getDeclaringType()
                + " " + pjp.getSignature().getName() + " argument: " + value.getBrand());

        Object retVal = pjp.proceed();

        System.out.println("After executing: "
                + pjp.getSignature().getDeclaringType()
                + " " + pjp.getSignature().getName()
                + " argument: " + value.getBrand());

        return retVal;
    }
}
