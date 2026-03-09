package org.example.Model;

public class User {

    private String Name;
    private String Phone;
    private String Password;
    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String  getPassword() {
        return Password;
    }

    public void setPassword(String  password) {
        Password = password;
    }

    public String  getPhone() {
        return Phone;
    }

    public void setPhone(String  phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
