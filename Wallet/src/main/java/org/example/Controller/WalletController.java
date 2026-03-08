package org.example.Controller;

import org.example.Service.TransactionService;
import org.example.Service.WalletService;

import java.util.Scanner;

public class WalletController {

    private WalletService walletService = new WalletService();
    private TransactionService transactionService = new TransactionService();
    // TODO initialize this object.
    private Scanner sc;

    // TODO there is no need to pass the scanner as an input, remove this constructor.
    public WalletController(Scanner sc) {
        this.sc = sc;
    }

    // TODO we need to split the validation logic from the method + change the parameter type and name.
    private double readValidAmount(String message) {
        double amount;
        while (true) {
            System.out.print(message);
            // TODO we need to use try catch for InputMismatchException.
            amount = sc.nextDouble();
            sc.nextLine();
            if (amount > 0) {
                return amount;
            }
            System.out.println("Amount must be positive!");
        }
    }

    public void walletMenu() {
        boolean logout = false;

        while (!logout) {
            System.out.println("\n--- Wallet Menu ---");
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. History");
            System.out.println("6. Logout");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            // TODO kindly not be lazy and use separated functions and also modern switch case.
                case 1:
                    System.out.println("Balance: " + walletService.getBalance());
                    break;

                case 2:
                    double depositAmount = readValidAmount("Amount to deposit: ");
                    walletService.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;

                case 3:
                    double withdrawAmount = readValidAmount("Amount to withdraw: ");
                    if (walletService.withdraw(withdrawAmount)) {
                        System.out.println("Withdraw successful!");
                    } else {
                        System.out.println("Not enough balance!");
                    }
                    break;

                case 4:
                    boolean transferSuccess = false;
                    while (!transferSuccess) {
                        System.out.print("Receiver Phone: ");
                        String receiverPhone = sc.nextLine();
                        double transferAmount = readValidAmount("Amount to transfer: ");
                        transferSuccess = walletService.transfer(receiverPhone, transferAmount);
                        if (transferSuccess) {
                            System.out.println("Transfer successful!");
                        } else {
                            System.out.println("Transfer failed! Try again.");
                        }
                    }

                    break;

                case 5:
                    transactionService.getHistory();
                    break;

                case 6:
                    logout = true;
                    System.out.println("Logged out!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}