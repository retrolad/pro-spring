package com.retrolad.ch10;

import com.retrolad.ch10.obj.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class DeveloperValidatorService {

    private Validator validator;

    public Set<ConstraintViolation<Developer>> validateDeveloper(Developer developer) {
        return validator.validate(developer);
    }

    public Validator getValidator() {
        return validator;
    }

    @Autowired
    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
