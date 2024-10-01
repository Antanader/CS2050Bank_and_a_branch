/*
Name: Anthony T
Date: 9.20.2024
Program: Saving Account Class
 */

class SavingsAccount extends BankAccount {
    private double interestRate;

    // Saving Account
    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    // Getters and Setters

    //InterestRate
    public double getInterestRate() {
        return interestRate;
    }

    //SetInterestRate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //Get Account Info
    public void getAccount(){
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + getInterestRate());
    }

    // Implement abstract methods
    //Deposit
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    //Withdraw
    public boolean withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    // Applying Interest
    public void applyInterest() {
        setBalance(getBalance() + (getBalance() * interestRate));
    }
}
