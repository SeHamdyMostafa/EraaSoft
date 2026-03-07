package org.example.Model;

public class Wallet {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        balance =balance+amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount < balance) {
            balance =balance-amount;
            return true;
        }
        return false;
    }

    public boolean transfer(Wallet receiver, double amount) {
        if (amount > balance) {
            return false;
        }
        balance =balance-amount;
        receiver.balance= receiver.balance+amount;
        return true;
    }
}
