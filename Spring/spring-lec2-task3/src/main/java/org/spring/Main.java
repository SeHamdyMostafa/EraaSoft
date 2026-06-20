package org.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {


     // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        PersonService p1 = context.getBean("personService", PersonService.class);
        p1.save("Ahmed");
        context.close();
    }
}