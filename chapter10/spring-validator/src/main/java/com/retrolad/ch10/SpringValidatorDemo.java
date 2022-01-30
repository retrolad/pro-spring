package com.retrolad.ch10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SpringValidatorDemo {

    private static final Logger logger = LoggerFactory.getLogger(SpringValidatorDemo.class);

    public static void main(String[] args) throws MalformedURLException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DeveloperValidator developerValidator = ctx.getBean("developerValidator", DeveloperValidator.class);

        Developer developer = new Developer();
        developer.setName(null);
        developer.setUrl(new URL("https://bethesda.com"));
        // Implementation of the Errors interface to hold
        // the result of validation
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(developer, "EA");

        ValidationUtils.invokeValidator(developerValidator, developer, result);
        List<ObjectError> errors = result.getAllErrors();
        logger.info("No of validation errors: " + errors.size());
        errors.forEach(e -> logger.info(e.getCode()));

        ctx.close();
    }
}
