package org.example.Controller;

import org.example.Service.AuthService;
import java.util.Scanner;

public class AuthController {
    private AuthService authService = new AuthService();
    private Scanner sc;

    public AuthController(Scanner sc){
        this.sc = sc;
    }

    private boolean isValidPhone(String phone){
        return phone.matches("\\d{11}");
    }

    private boolean isValidPassword(String password){
        return password.length() >= 8;
    }

    public void handleRegister(){

        System.out.print("Name: ");
        String name = sc.nextLine();

        String phone;
        while(true){
            System.out.print("Phone (11 digits): ");
            phone = sc.nextLine();
            if(isValidPhone(phone)) break;
            System.out.println("Invalid phone. Must be 11 digits!");
        }

        String password;
        while(true){
            System.out.print("Password (min 8 chars): ");
            password = sc.nextLine();
            if(isValidPassword(password)) break;
            System.out.println("Password too short!");
        }

        if(authService.register(name, phone, password)){
            System.out.println("Registered successfully!");
        }else{
            System.out.println("Phone already used!");
        }
    }

    public boolean handleLogin(){
        while(true){
            System.out.print("Phone: ");
            String phone = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            if(authService.login(phone,password)){
                System.out.println("Login successful!");
                return true;
            }else{
                System.out.println("Invalid phone or password!");
            }
        }
    }
}