package org.example.Storage;

import org.example.Model.Transaction;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataStore {

    private static DataStore instance;

    private List<User> users = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private Optional<User> currentUser = Optional.empty();

    private DataStore() {}

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Optional<User> getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = Optional.ofNullable(user);
    }

}