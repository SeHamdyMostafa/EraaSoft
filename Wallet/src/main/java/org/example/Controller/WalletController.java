package org.example.Controller;

import org.example.Service.AuthService;
import org.example.Service.WalletService;
import org.example.Service.TransactionService;

import java.util.Scanner;

public class WalletController {
    private WalletService walletService = new WalletService();
    private AuthService authService=new AuthService();
    private TransactionService transactionService = new TransactionService();
    private AuthController authController = new AuthController();
    private ValidationUtil validationUtil = new ValidationUtil();
    private Scanner sc = new Scanner(System.in);

    public void walletMenu() {
        boolean logout = false;

        while (!logout) {
            System.out.println("\n--- Wallet Menu ---");
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. History");
            System.out.println("6. Change Password");
            System.out.println("7. User Details");
            System.out.println("8. Logout");

            System.out.print("Choose: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Enter a number between 1 and 7.");
                continue;
            }

            switch (choice) {
                case 1 -> System.out.println("Balance: " + walletService.getBalance());
                case 2 -> {
                    double depositAmount = validationUtil.validateAmount("Amount to deposit: ");
                    walletService.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                }

                case 3 -> {
                    while (true) {
                        double withdrawAmount = validationUtil.validateAmount("Amount to withdraw: ");
                        if (walletService.withdraw(withdrawAmount)) {
                            System.out.println("Withdraw successful!");
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Receiver Phone: ");
                    String receiverPhone = validationUtil.validatePhone();
                    while (true) {

                        double transferAmount = validationUtil.validateAmount("Amount to transfer: ");
                        boolean success = walletService.transfer(receiverPhone, transferAmount);
                        if (success) {
                            System.out.println(" Transfer successful!");
                            break;
                        }
                    }
                }

                case 5 -> transactionService.getHistory();

                case 6 ->authController.handleChangePassword();
                case 7-> authService.getUserDetails();

                case 8 -> {
                    logout = true;
                    System.out.println("Logged out!");
                }

                default -> System.out.println("Invalid choice! Enter a number between 1 and 7.");
            }
        }
    }
}