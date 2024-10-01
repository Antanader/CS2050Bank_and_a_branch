/*
Name: Anthony T
Date: 9.20.2024
Program: Checking Account Class
 */

class CheckingAccount extends BankAccount {
    private double overdraft;


    //Setting Checking Account
    public CheckingAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    // Getters and Setters
    //Overdraft on Checking Account

    //Get Account Info
    public void getAccount() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Balance: " + getBalance());
    }


    // Implement abstract methods

    //deposit
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    //withdraw with checking overdraft limit
    public boolean withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
} //end
