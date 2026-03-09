package org.example.Controller;

import org.example.Storage.DataStore;
import org.example.Model.User;

import java.util.Scanner;

public class ValidationUtil {
    private Scanner sc = new Scanner(System.in);

    // ===== PHONE VALIDATION =====
    public String validatePhone() {
        String phone;
        while (true) {
            System.out.print("Enter phone number (11 digits, starts with 010/011/012/015): ");
            phone = sc.nextLine().trim();
            if (phone.isEmpty()) {
                System.out.println("Phone number cannot be empty! Try again.");
                continue;
            }
            if (!phone.matches("^(010|011|012|015)\\d{8}$")) {
                System.out.println("Invalid phone number format! Try again.");
                continue;
            }
            break;
        }
        return phone;
    }

    // ===== PASSWORD VALIDATION =====
    public String validatePassword(String message) {
        String password;
        while (true) {
            System.out.print(message);
            password = sc.nextLine().trim();
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty! Try again.");
                continue;
            }
            if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$")) {
                System.out.println("Password format invalid! Must include uppercase, lowercase, number, special char.");
                continue;
            }
            break;
        }
        return password;
    }

    // ===== USERNAME VALIDATION =====
    public String validateUsername() {
        while (true) {
            System.out.print("Enter your name: ");
            String username = sc.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("Name cannot be empty! Try again.");
                continue;
            }

            if (!username.matches("^[A-Z][a-zA-Z]{2,}$")) {
                System.out.println("Name must be at least 3 letters, start with uppercase, letters only.");
                continue;
            }

            return username;
        }
    }

    // ===== AMOUNT VALIDATION =====
    public double validateAmount(String message) {
        double amount;
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Amount cannot be empty! Try again.");
                continue;
            }

            try {
                amount = Double.parseDouble(input);
                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0! Try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid number.");
            }
        }
        return amount;
    }
}