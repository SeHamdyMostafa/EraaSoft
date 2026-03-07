package org.example.Storage;

import org.example.Model.Transaction;
import org.example.Model.User;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Transaction> transactions=new ArrayList<>();
    public static User currentUser = null;
}
