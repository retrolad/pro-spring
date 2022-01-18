package com.retrolad.ch03.config;

import com.retrolad.ch03.annotated.AbstractLookupDemoBean;
import com.retrolad.ch03.annotated.DemoBean;
import com.retrolad.ch03.annotated.Singer;
import com.retrolad.ch03.annotated.StandardLookupDemoBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

    @Configuration
    @ComponentScan(basePackages = "com.retrolad.ch03.annotated")
    public static class LookupDemoConfig {}

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LookupDemoConfig.class);

        DemoBean abstractBean = ctx.getBean(AbstractLookupDemoBean.class);
        DemoBean standardBean = ctx.getBean(StandardLookupDemoBean.class);

        displayIndo("abstractLookupBean", abstractBean);
        displayIndo("standardLookupBean", standardBean);
    }

    public static void displayIndo(String beanName, DemoBean bean) {

        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();

        System.out.println(beanName + ": Same singer? - " + (singer1 == singer2));

        StopWatch sw = new StopWatch();
        sw.start("lookupDemo");

        for(int x = 0; x < 100000; x++) {
            Singer singer = bean.getMySinger();
            singer.sing();
        }

        sw.stop();
        System.out.println("100000 gets took " + sw.getTotalTimeMillis() + " ms");

    }
}
