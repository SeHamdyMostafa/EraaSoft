package org.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("personService")
@Scope("singleton")
public class PersonService implements UserService{
    @Override
    public void save(String name) {
        System.out.println("Person Saved: " + name);
    }
    @PostConstruct
    public void init() {
        System.out.println("Open Connection");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Close Connection");
    }
}
