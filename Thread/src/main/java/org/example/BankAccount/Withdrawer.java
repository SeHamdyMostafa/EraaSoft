package org.example.BankAccount;

public class Withdrawer extends Thread{

    private BankAccount account;

    Withdrawer(BankAccount account){
        this.account = account;
    }
    public void run(){
        try {
            while (true) {
                Thread.sleep(1000);
                account.withdraw(150);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
