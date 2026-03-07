package org.example.Service;

import org.example.Model.User;
import org.example.Storage.DataStore;

public class WalletService {

    private TransactionService transactionService = new TransactionService();

    public double getBalance() {
        return DataStore.currentUser.getWallet().getBalance();
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        DataStore.currentUser.getWallet().deposit(amount);
        transactionService.addTransaction("Deposit", amount, DataStore.currentUser.getPhone(), ""
        );
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        boolean success = DataStore.currentUser.getWallet().withdraw(amount);
        if (success) {
            transactionService.addTransaction("Withdraw", amount, DataStore.currentUser.getPhone(), ""
            );
        }
        return success;
    }

    public boolean transfer(String receiverPhone, double amount) {
        if (amount <= 0) {
            return false;
        }
        if (receiverPhone.equals(DataStore.currentUser.getPhone())) {
            System.out.println("You cannot transfer to yourself!");
            return false;
        }

        User receiver = null;
        for (User user : DataStore.users) {
            if (user.getPhone().equals(receiverPhone)) {
                receiver = user;
                break;
            }
        }
        if (receiver == null) {
            System.out.println("Receiver not found!");
            return false;
        }
        boolean success = DataStore.currentUser.getWallet().transfer(receiver.getWallet(), amount);
        if (success) {
            transactionService.addTransaction("Transfer", amount, DataStore.currentUser.getPhone(), receiverPhone
            );
        }
        return success;
    }
}