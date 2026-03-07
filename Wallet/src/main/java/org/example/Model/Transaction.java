package org.example.Model;

import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private Date date;
    private String fromUser;
    private String toUser;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String toString(){
        return "[" + date + "] " + type +
                " | amount: " + amount +
                " | from: " + fromUser +
                " | to: " + toUser;
    }


}
