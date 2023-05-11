package org.example;

public class Main {
    public static void main(String[] args) {
    BankAccount account = new BankAccount(1000);
    account.deposit(500);
    account.withdraw(2000);
    System.out.println(account.getBalance());
    }
}