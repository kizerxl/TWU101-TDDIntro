package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void addMoney(int amount) {
        balance += amount;
    }

    public int getCurrentBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if(amount > balance) {
            return;
        }
        balance -= amount;
    }
}
