package org.example;

import org.example.Controller.AuthController;
import org.example.Controller.WalletController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthController authController = new AuthController(sc);
        WalletController walletController = new WalletController(sc);

        while(true){

            System.out.println("\n=== Wallet App ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    authController.handleRegister();
                    break;

                case 2:
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