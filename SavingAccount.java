/*
Name: Anthony T
Date: 9.20.2024
Program: Saving Account Class
 */

class SavingsAccount extends Account {
    private double interestRate;

    // Saving Account
    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
        //this.interestRate = interestRate;
        getAccount();
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
        System.out.println("Saving Account Number: " + getAccountNumber());
        System.out.println("Saving Account Name: " + getAccountName());
        System.out.println("Saving Balance: " + getBalance());
        System.out.println("\n");
        //System.out.println("Interest Rate: " + getInterestRate());
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

    @Override
    public String toString() {
        return "Saving Account Number: " + getAccountNumber() + "\n" + "Saving Account Name: " + getAccountName() + "\n"+ "Saving Balance: $" + getBalance() + "\n";
    }
}
