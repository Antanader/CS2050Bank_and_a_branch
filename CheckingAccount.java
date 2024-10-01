/*
Name: Anthony T
Date: 9.20.2024
Program: Checking Account Class
 */

class CheckingAccount extends Account {
    private double overdraft;


    //Setting Checking Account
    public CheckingAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
        getAccount();
    }

    // Getters and Setters
    //Overdraft on Checking Account

    //Get Account Info
    public void getAccount() {
        System.out.println("Checking Account Number: " + getAccountNumber());
        System.out.println("Checking Account Name: " + getAccountName());
        System.out.println("Checking Balance: " + getBalance());
        System.out.println("\n");
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

    @Override
    public String toString() {
        return "Checking Account Number: " + getAccountNumber() + "\n" + "Checking Account Name: " + getAccountName() + "\n"+ "Checking Balance: $" + getBalance() + "\n";
    }
} //end
