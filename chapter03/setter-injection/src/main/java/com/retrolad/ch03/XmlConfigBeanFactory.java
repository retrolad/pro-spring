package com.retrolad.ch03;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigBeanFactory {
    public static void main(String[] args) {
        // Implementation of a BeanFactory that will store all beans?
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(factory);
        definitionReader.loadBeanDefinitions(new ClassPathResource("spring/xml-bean-factory-config.xml"));

        Oracle oracle = factory.getBean("oracle", Oracle.class);
        System.out.println(oracle.defineMeaningOfLife());
    }
}
