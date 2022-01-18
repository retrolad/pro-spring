package com.retrolad.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml.xml");

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
