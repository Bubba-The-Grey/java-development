package com.pluralsight;

public class CreditCard implements Valuable{
    private String name, accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getValue() {
        return balance;
    }

    public void charge(double amount){
        this.balance -= amount;
    }

    public void pay(double amount){
        this.balance += amount;
    }
}
