package com.retrolad.ch10;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component("developerValidator")
public class DeveloperValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Developer.class.equals(clazz);
    }

    // Validate the given object, which must be of a Class
    // for which supports method has returned true
    @Override
    public void validate(Object target, Errors errors) {
        // Reject the given field with the given error code
        // Empty means null or ""
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
    }
}
