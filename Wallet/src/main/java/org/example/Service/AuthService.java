package org.example.Service;

import org.example.Model.User;
import org.example.Model.Wallet;
import org.example.Storage.DataStore;

public class AuthService {


    private DataStore dataStore = DataStore.getInstance();
    public boolean register(String name, String phone, String password) {

        boolean nameExists = dataStore.getUsers().stream()
                .anyMatch(user -> user.getName().equalsIgnoreCase(name));
        boolean phoneExists = dataStore.getUsers().stream()
                .anyMatch(user -> user.getPhone().equals(phone));

        if (nameExists && phoneExists) {
            System.out.println(" Both name and phone number already exist!");
            return false;
        } else if (nameExists) {
            System.out.println(" Name already exists!");
            return false;
        } else if (phoneExists) {
            System.out.println(" Phone number already exists! ");
            return false;
        }

        User newUser = new User();
        newUser.setName(name);
        newUser.setPhone(phone);
        newUser.setPassword(password);
        newUser.setWallet(new Wallet());
        dataStore.addUser(newUser);

        System.out.println(" Registration successful!");
        return true;
    }

    public boolean login(String phone, String password){

        return dataStore.getUsers().stream()
                .filter(user -> user.getPhone().equals(phone) && user.getPassword().equals(password))
                .findFirst()
                .map(user -> {
                    dataStore.setCurrentUser(user);
                    return true;
                })
                .orElse(false);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        return dataStore.getCurrentUser()
                .map(user -> {
                    if (!user.getPassword().equals(oldPassword)) {
                        System.out.println("Old password is incorrect!");
                        return false;
                    }
                    user.setPassword(newPassword);
                    System.out.println("Password changed successfully!");
                    return true;
                })
                .orElseGet(() -> {
                    System.out.println("No user is currently logged in!");
                    return false;
                });
    }

}