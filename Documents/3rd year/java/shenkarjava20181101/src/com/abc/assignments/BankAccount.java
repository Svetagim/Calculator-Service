package com.abc.assignments;

public class BankAccount {

    private double balance;
    private int id;

    public BankAccount(int id, double balance) {
        setBalance(balance);
        setId(id);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void deposit(double sum) {
        if(sum>0) {
            this.balance += sum;
        }
    }

    public void withdraw(double sum) {
        if(sum>0 && this.balance>sum) {
            this.balance -= sum;
        }
    }
}
