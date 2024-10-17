/*
Name: Anthony T
Date: 9.20.2024
Program: Bank Account Class
 */


import java.io.Serializable;
import java.util.Random;

abstract class Account implements Serializable {
    private static String accountNumber;
    private String accountHolderName;
    private double balance;

    // Bank Account Constructor
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    //
    public Account(String accountHolderName){
        this.accountNumber = String.valueOf(generateAccountNumber());
        this.accountHolderName = accountHolderName;
        this.balance = 1000.00;
    }

    // Account Number Generator
    private static long generateAccountNumber() {
        Random random = new Random();
        return 100000000000L + (long) (random.nextDouble() * 900000000000L);
    }

    // Account Number Get
    public static String getAccountNumber() {
        return accountNumber;
    }

    // Set Account Number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Get Account Name
    public String getAccountName() {
        return accountHolderName;
    }

    // Set Account Name
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Get Account Info
    public void getAccount() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Balance: " + getBalance());
        System.out.println("\n");
    }

    // Balance
    public double getBalance() {
        return balance;
    }

    // Set Balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit
    public abstract void deposit(double amount);

    // Withdraw
    public abstract boolean withdraw(double amount);
}


/*

import java.util.Random;

abstract class Account extends ProgramTest {
    private static String accountNumber;
    private String accountHolderName;
    private double balance;

    // Bank Account Constructor
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    //
    public Account(String accountHolderName){
        this.accountNumber = String.valueOf(generateAccountNumber());
        this.accountHolderName = accountHolderName;
        this.balance = 1000.00;
    }

    //Account Number Generator
    private static long generateAccountNumber () {
        Random random = new Random();
        return 100000000000L + (long) (random.nextDouble() * 900000000000L);
    }
    //Account Number Get
    public static String getAccountNumber() {
        return accountNumber;
    }
    //Set Account Number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //Get Account Name
    public String getAccountName() {
        return accountHolderName;
    }

    //Set Account Name
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    //Get Account Info
    public void getAccount() {
            System.out.println("Account Number: " + getAccountNumber());
            System.out.println("Account Name: " + getAccountName());
            System.out.println("Balance: " + getBalance());
            System.out.println("\n");
    }
    //Balance
    public double getBalance() {
        return balance;
    }

    //Set Balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit
    public abstract void deposit(double amount);
    // withdraw
    public abstract boolean withdraw(double amount);
}
*/