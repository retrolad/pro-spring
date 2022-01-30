package com.retrolad.ch10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "com.retrolad.ch10")
public class AppConfig {

    final
    ApplicationConversionServiceFactoryBean conversionService;

    public AppConfig(ApplicationConversionServiceFactoryBean conversionService) {
        this.conversionService = conversionService;
    }

    @Bean
    public Developer developer() throws ParseException, MalformedURLException {
        Developer developer = new Developer();
        developer.setName("Bethesda");
        developer.setFoundingTime(conversionService.getDateTimeFormatter().parse("1986-10-14", Locale.ENGLISH));
        developer.setUrl(new URL("http://bethesda.com"));
        return developer;
    }
}
