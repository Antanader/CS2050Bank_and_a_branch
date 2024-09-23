/*
Name: Anthony Talavera
Date: 9.20.2024
Program: Bank Account Class
 */


abstract class BankAccount{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Bank Account Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters and Setters

    //Account Number Get
    public String getAccountNumber() {
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
