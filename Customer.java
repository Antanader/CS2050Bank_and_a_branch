/*
Name: Anthony T
Date: 10.10.2024
Program: Customer Class
 */

class Customer extends Account {

    public Customer(String accountHolderName) {
        super(accountHolderName);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Customer Name: " + getAccountName() + "\n" + "Account Number: " + getAccountNumber() + "\n" + "Balance: " + getBalance() + "\n";
    }
}

