package org.example.BankAccount;

public class BankAccount {

    private int balance=0;

    public synchronized void deposit(int amount){
        balance=amount+balance;
        System.out.println("Deposited: " + amount + " | Balance = " + balance);
        notify();

    }

    public synchronized void withdraw(int amount){
        if(balance>amount){
            balance=balance-amount;
            System.out.println("Withdrawn: " + amount + " | Balance = " + balance);
        }else try {
            System.out.println("Not enough balance... waiting");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
