package org.item.service;

import org.item.models.UserModel;
import org.item.repo.UserRepo;
import org.item.validation.UserValidation;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final UserRepo repo = new UserRepo();

    public List<String> register(UserModel user) {

        List<String> errors = UserValidation.validateRegister(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );

        if (!errors.isEmpty()) {
            return errors;
        }
        boolean success = repo.SignUp(user);
        if (!success) {
            errors.add("Registration failed. Try again.");
            return errors;
        }
        return new ArrayList<>();
    }

    public List<String> login(String email, String password) {

        List<String> errors = UserValidation.validateLogin(email, password);
        if (!errors.isEmpty()) {
            return errors;
        }
        UserModel user = repo.login(email, password);
        if (user == null) {
            errors.add("Invalid email or password");
            return errors;
        }
        return new ArrayList<>();
    }

    public UserModel getUser(String email, String password) {
        return repo.login(email, password);
    }
}