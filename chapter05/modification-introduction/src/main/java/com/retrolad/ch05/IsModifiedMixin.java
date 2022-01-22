package com.retrolad.ch05;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// This class represents an advice
public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {

    private boolean isModified;
    Map<Method, Method> cachedMethods = new HashMap<>();

    @Override
    public boolean isModified() {
        return isModified;
    }

    /**
     * Sets {@link #isModified} to true, if a setter was called,
     * and passed value is different from existing one, meaning
     * the object's state was modified
     * @param mi Method invocation descriptor
     * @return The result of original method call
     * @throws Throwable Exception
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if(!isModified) {
            if((mi.getMethod().getName().startsWith("set"))
                && (mi.getArguments().length == 1)) {
                Method setter = mi.getMethod();

                Method getter = getGetter(setter);

                if(getter != null) {
                    Object newVal = mi.getArguments()[0];
                    Object oldVal = getter.invoke(mi.getThis(), null);

                    if((newVal == null) && (oldVal == null))
                        isModified = false;

                    else if((newVal == null) && (oldVal != null))
                        isModified = true;

                    else if ((newVal != null) && (oldVal == null)) {
                        isModified = true;
                    }

                    else {
                        isModified = !newVal.equals(oldVal);
                    }
                }
            }
        }

        return super.invoke(mi);
    }

    // Get corresponding getter method using reflection
    private Method getGetter(Method setter) {
        Method getter = cachedMethods.get(setter);

        if(getter != null)
            return getter;

        String getterName = setter.getName().replaceFirst("set", "get");
        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);

            synchronized (cachedMethods) {
                cachedMethods.put(setter, getter);
            }

            return getter;
        } catch(NoSuchMethodException ex) {
            return null;
        }
    }
}
