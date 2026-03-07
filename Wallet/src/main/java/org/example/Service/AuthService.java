package org.example.Service;

import org.example.Model.User;
import org.example.Model.Wallet;
import org.example.Storage.DataStore;

public class AuthService {
    public boolean register(String name, String phone, String password) {

        for (User u : DataStore.users) {
            if (u.getPhone().equals(phone)) {
                return false;
            }
        }
        User newUser = new User();
        newUser.setName(name);
        newUser.setPhone(phone);
        newUser.setPassword(password);
        newUser.setWallet(new Wallet());

        DataStore.users.add(newUser);

        return true;
    }

    public boolean login(String phone, String password){
        for(User u : DataStore.users){
            if(u.getPhone().equals(phone) && u.getPassword().equals(password)){
                DataStore.currentUser=u;
                return true;
            }
        }
        return false;
    }

}
