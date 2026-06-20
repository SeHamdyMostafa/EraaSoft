package com.spring.main;

import com.spring.AccountServiceImpl;
import com.spring.SpringConfig;
import com.spring.interfaces.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.user.MangerService;
import com.spring.user.PersonService;


public class Main {
    public static void main(String[] args) {

        //ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountServiceImpl accountService = applicationContext.getBean("accountService", AccountServiceImpl.class);
        accountService.getSavePerson("ahmed");
        accountService.getUpdatePerson("ahmed mohamed");


        System.out.println();
        MangerService manager = applicationContext.getBean("mangerService", MangerService.class);
        manager.save("Ali");
        manager.update("Ali basha");

        System.out.println();
        PersonService person =applicationContext.getBean("personService",PersonService.class);
        person.save("amged");
        person.update("mohamed amged");


    }
}