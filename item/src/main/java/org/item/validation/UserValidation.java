package org.item.validation;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    public static List<String> validateRegister(String username, String email, String password) {

        List<String> errors = new ArrayList<>();

        if (username == null || username.trim().isEmpty()) {
            errors.add("Username is required");
        } else if (username.trim().length() < 3) {
            errors.add("Username must be at least 3 characters");
        } else if (username.matches("\\d+")) {
            errors.add("Username cannot be only numbers");
        }

        if (email == null || email.trim().isEmpty()) {
            errors.add("Email is required");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.add("Invalid email format");
        }

        if (password == null || password.trim().isEmpty()) {
            errors.add("Password is required");
        } else if (password.length() < 6) {
            errors.add("Password must be at least 6 characters");
        }

        return errors;
    }

    public static List<String> validateLogin(String email, String password) {

        List<String> errors = new ArrayList<>();

        if (email == null || email.trim().isEmpty()) {
            errors.add("Email is required");
        }

        if (password == null || password.trim().isEmpty()) {
            errors.add("Password is required");
        }

        return errors;
    }
}