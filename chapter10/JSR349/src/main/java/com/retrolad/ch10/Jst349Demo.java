package com.retrolad.ch10;

import com.retrolad.ch10.obj.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Jst349Demo {

    private static final Logger logger = LoggerFactory.getLogger(Jst349Demo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DeveloperValidatorService developerValidatorService = ctx.getBean(DeveloperValidatorService.class);

        Developer developer = new Developer();
        developer.setName("B");
        developer.setGenre(null);

        Set<ConstraintViolation<Developer>> constraintViolations = developerValidatorService.validateDeveloper(developer);
        listViolations(constraintViolations);
    }

    private static void listViolations(Set<ConstraintViolation<Developer>> violations) {

    }
}
