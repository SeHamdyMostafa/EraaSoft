package org.example.Controller;

import org.example.Service.AuthService;

public class AuthController {
    private AuthService authService = new AuthService();
    private ValidationUtil validationUtil = new ValidationUtil();

    // ===== REGISTER =====
    public void handleRegister() {
        while (true) {
            String name = validationUtil.validateUsername();
            String phone = validationUtil.validatePhone();
            String password = validationUtil.validatePassword("Enter Your Password");
            boolean registered = authService.register(name, phone, password);
            if (registered) {
                break;
            } else {
                System.out.println("Please try registering again .");

            }
        }
    }

    // ===== LOGIN =====
    public boolean handleLogin() {
        final int MAX_ATTEMPTS = 4;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            String phone = validationUtil.validatePhone();
            String password = validationUtil.validatePassword("Enter Your Password");

            if (authService.login(phone, password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Incorrect phone or password!");
                attempts++;
            }
        }

        System.out.println("Maximum login attempts reached. Please try later.");
        return false;
    }

    // ===== CHANGE PASSWORD =====
    public void handleChangePassword() {
        while (true){
            String oldPassword = validationUtil.validatePassword("Enter Old Password: ");
            String newPassword = validationUtil.validatePassword("Enter New Password: ");
            if (authService.changePassword(oldPassword, newPassword)) {
                break;
            } else {
                System.out.println("Please try again.\n");
            }
        }
    }
}