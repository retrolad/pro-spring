package com.retrolad.ch10;

import com.retrolad.ch10.obj.Developer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

// Define the logic of special validator
public class FpsDeveloperValidator implements ConstraintValidator<CheckFpsDeveloper, Developer> {

    @Override
    public boolean isValid(Developer value, ConstraintValidatorContext context) {
        boolean isValid = true;
        if(value.getGenre() != null && value.isFpsDeveloper() && value.getName() == null) {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public void initialize(CheckFpsDeveloper constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
