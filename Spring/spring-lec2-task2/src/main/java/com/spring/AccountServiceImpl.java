package com.spring;

import com.spring.interfaces.AccountService;
import com.spring.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("accountService")
public class AccountServiceImpl implements AccountService {

    private UserService userService;

   /*
    public AccountServiceImpl( UserService userService){
        this.userService=userService;
    }
*/

    @Override
    public void getSavePerson(String name) {
        userService.save(name);
    }

    @Override
    public void getUpdatePerson(String name) {
        userService.update(name);
    }
    @Autowired
    public void setUserService(@Qualifier("personService") UserService userService) {
        this.userService = userService;
    }

}
