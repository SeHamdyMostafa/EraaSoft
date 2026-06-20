package com.spring.main;

import com.spring.SpringConfig;
import com.spring.interfaces.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.user.MangerService;
import com.spring.user.PersonService;


public class Main {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService person = applicationContext.getBean("personService", PersonService.class);
        UserService manager = applicationContext.getBean("mangerService", MangerService.class);

        person.save("Ahmed");
        person.update("Ahmed");

        System.out.println();
        manager.save("Ali");
        manager.update("Ali");
    }
}