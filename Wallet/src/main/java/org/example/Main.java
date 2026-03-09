package org.example;

import org.example.Controller.AuthController;
import org.example.Controller.WalletController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthController authController = new AuthController();
        WalletController walletController = new WalletController();

        while(true){

            System.out.println("\n=== Wallet App ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = -1;

            while (true) {
                System.out.print("Choose (1-3): ");
                try {
                    choice = Integer.parseInt(sc.nextLine());

                    if (choice >= 1 && choice <= 3) {
                        break; // رقم صحيح وفي الحدود
                    } else {
                        System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                }
            }

            switch (choice){

                case 1:
                    System.out.println("Register");
                    authController.handleRegister();
                    break;

                case 2:
                    System.out.println("Login");
                    if(authController.handleLogin()){
                        walletController.walletMenu();
                    }
                    break;

                case 3:
                    System.out.println("Bye!");
                    return;
            }
        }
    }
}