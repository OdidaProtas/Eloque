package com.moringaschool.eloque.models;

public class Users {
    private int balance;
    private String uid;

    public Users(int balance, String uid) {
        this.balance = balance;
        this.uid = uid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
