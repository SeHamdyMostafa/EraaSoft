package com.spring.user;

import com.spring.interfaces.UserService;
import org.springframework.stereotype.Component;

@Component("mangerService")
public class MangerService implements UserService {
    @Override
    public void save(String name)
    {
        System.out.println("Manager Saved : " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("Manager Updated : " + name);

    }
}
