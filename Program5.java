/*
Name: Anthony T
Date: 9.20.2024
Program: Bank Test Program
 */

import java.io.*;
import java.util.Random;

public class Program5 {
    public static void main(String[] args) {

        // Create Stack for CheckingAccount and SavingAccount
        Stack<CheckingAccount> checkingStack = new Stack<>();
        Stack<SavingsAccount> savingStack = new Stack<>();

        // Create and push 25 CheckingAccount objects onto the checkingStack
        for (int i = 1; i <= 25; i++) {
            long checkingAccountNumber = generateAccountNumber();
            CheckingAccount checkingAccount = new CheckingAccount(String.valueOf(checkingAccountNumber), "Anthony Talavera",2000);
            checkingStack.push(checkingAccount);
        }

        // Create and push 25 SavingAccount objects onto the savingStack
        for (int i = 1; i <= 25; i++) {
            long savingAccountNumber = generateAccountNumber();
            SavingsAccount savingAccount = new SavingsAccount(String.valueOf(savingAccountNumber),"Anthony Talavera", 2000);
            savingStack.push(savingAccount);
        }

        // Write the stacks to files
        try {
            checkingStack.writeStackToFile("CheckingStack.txt");
            savingStack.writeStackToFile("SavingStack.txt");
        } catch (IOException e) {
            System.out.println("Error writing stack to file: " + e.getMessage());

        }
    }
    //Account Number Generator
    private static long generateAccountNumber(){
        Random random = new Random();
        return 100000000000L + (long)(random.nextDouble() * 900000000000L);
    }
}
