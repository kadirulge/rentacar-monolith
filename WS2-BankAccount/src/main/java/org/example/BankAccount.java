package org.example;

public class BankAccount {
    private double balance;

    public BankAccount(double InitialBalance) {
        balance = InitialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        balance =  newBalance;
    }

    public void deposit(double amount) { // para yatırma
        balance = balance + amount;
    }

    public void withdraw(double amount) { // para çekme
        if(balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Yetersiz bakiye");
        }
    }



}
