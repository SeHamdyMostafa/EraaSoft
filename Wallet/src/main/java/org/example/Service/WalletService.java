package org.example.Service;

import org.example.Model.User;
import org.example.Storage.DataStore;

public class WalletService {

    private DataStore dataStore = DataStore.getInstance();
    private TransactionService transactionService = new TransactionService();

    // =================== GET BALANCE ===================
    public double getBalance() {
        return dataStore.getCurrentUser().get().getWallet().getBalance();
    }

    // =================== DEPOSIT ===================
    public void deposit(double amount) {
        dataStore.getCurrentUser().get().getWallet().deposit(amount);
        transactionService.addTransaction(
                "Deposit",
                amount,
                dataStore.getCurrentUser().get().getPhone(),
                ""
        );
    }

    // =================== WITHDRAW ===================
    public boolean withdraw(double amount) {
        boolean success = dataStore.getCurrentUser().get().getWallet().withdraw(amount);

        if (amount > dataStore.getCurrentUser().get().getWallet().getBalance()) {
            System.out.println("Insufficient balance");
            return false;
        }

        if (success) {
            transactionService.addTransaction(
                    "Withdraw",
                    amount,
                    dataStore.getCurrentUser().get().getPhone(),
                    ""
            );
        }
        return success;
    }

    // =================== TRANSFER ===================
    public boolean transfer(String receiverPhone, double amount) {
        String currentPhone = dataStore.getCurrentUser().get().getPhone();

        if (receiverPhone.equals(currentPhone)) {
            System.out.println("You cannot transfer to yourself!");
            return false;
        }

        User receiver = dataStore.getUsers()
                .stream()
                .filter(u -> u.getPhone().equals(receiverPhone))
                .findFirst()
                .orElse(null);


        if (receiver == null) {
            System.out.println("Receiver not found!");
            return false;
        }

        if (amount > dataStore.getCurrentUser().get().getWallet().getBalance()) {
            System.out.println("Insufficient balance");
            return false;
        }

        boolean success = dataStore.getCurrentUser()
                .get()
                .getWallet()
                .transfer(receiver.getWallet(), amount);

        if (success) {
            transactionService.addTransaction(
                    "Transfer",
                    amount,
                    currentPhone,
                    receiverPhone
            );
        }

        return success;
    }
}