package com.retrolad.ch03.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {

    private List<Object> list;
    private Map<String, Object> map;
    private Set<Object> set;
    private Properties props;

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml.xml");
        ctx.getBean("collectionInjection", CollectionInjection.class).displayInfo();
    }

    public void displayInfo() {
        System.out.println("List content:\n");
        list.forEach(e -> System.out.println("Value: " + e));

        System.out.println("\nMap content:\n");
        map.forEach((key, value) -> System.out.println("Key: " + key + " - " + "Value: " + value));

        System.out.println("\nSet content:\n");
        set.forEach(e -> System.out.println("Value: " + e));

        System.out.println("\nProperties content:\n");
        props.forEach((key, value) -> System.out.println("Key: " + key + " - " + "Value: " + value));
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
}
