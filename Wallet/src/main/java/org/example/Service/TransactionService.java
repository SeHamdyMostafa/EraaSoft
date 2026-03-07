package org.example.Service;

import org.example.Model.Transaction;
import org.example.Storage.DataStore;

import java.util.Date;

public class TransactionService {

    public void addTransaction(String type, double amount, String fromUser, String toUser){
        Transaction transaction=new Transaction();
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setFromUser(fromUser);
        transaction.setToUser(toUser);
        transaction.setDate(new Date());
        DataStore.transactions.add(transaction);

    }
    public void getHistory(){
        for (Transaction t:DataStore.transactions){
            System.out.println("Transaction "+ t);
        }
    }
}
