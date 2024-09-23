/*
Name: Anthony Talavera
Date: 9.20.2024
Program: Bank Test Program
 */

public class BankTest {
    public static void main(String[] args) {

        // Calling Checking Account to Create new Account
        SavingsAccount savingAccount1 = new SavingsAccount("1234567", "Anthony Talavera",5000,.05);
        // depositing additional money
        savingAccount1.deposit(2500);
        savingAccount1.getAccount();

        System.out.println("\n");

        // Create a Checking Account
        CheckingAccount checkingAccount1 = new CheckingAccount("1234567", "Anthony Talavera", 5000);
        checkingAccount1.withdraw(2500);
        checkingAccount1.getAccount();
        System.out.println("\n");

        //Create CD Account
        CDAccount CDAccount1 = new CDAccount("1234567","Anthony Talavera",2500,10);
        CDAccount1.getAccount();
        System.out.println("\n");

    }
}