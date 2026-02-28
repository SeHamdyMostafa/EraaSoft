package org.example.BankAccount;

public class MainBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Depositor d = new Depositor(account);
        Withdrawer w = new Withdrawer(account);

        d.start();
        w.start();
    }
}
