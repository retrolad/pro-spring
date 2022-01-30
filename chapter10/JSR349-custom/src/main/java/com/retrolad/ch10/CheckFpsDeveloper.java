package com.retrolad.ch10;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// Marks as Bean validator constraint
@Constraint(validatedBy = FpsDeveloperValidator.class)
public @interface CheckFpsDeveloper {
    // Returning error message in case of constraint violation
    String message() default "Fps Developer should have last name defined";
    Class<?>[] groups() default {};
    // Additional constraint information
    Class<? extends Payload>[] payload() default {};
}
