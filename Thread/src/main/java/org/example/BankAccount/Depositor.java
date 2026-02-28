package org.example.BankAccount;

public class Depositor extends Thread{
    private BankAccount account;

    Depositor(BankAccount account){
        this.account = account;
    }

    public void run(){
        try {
            while (true) {
                Thread.sleep(2500);
                account.deposit(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
