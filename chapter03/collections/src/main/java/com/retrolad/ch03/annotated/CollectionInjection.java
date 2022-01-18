package com.retrolad.ch03.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

@Service("injectCollection")
public class CollectionInjection {

    @Autowired
    @Qualifier("map")
    private Map<String, Object> map;
    @Resource(name = "list")
    private List<Object> list;
    @Resource(name = "set")
    private Set<Object> set;
    @Resource(name = "props")
    private Properties props;

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation.xml");
        ctx.getBean("injectCollection", CollectionInjection.class).displayInfo();
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
