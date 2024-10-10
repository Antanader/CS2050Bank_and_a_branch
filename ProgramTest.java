/*
Name: Anthony T
Date: 10.10.2024
Program: Bank Test Program
 */

import java.io.*;

public class ProgramTest {
    public static void main(String[] args) {

        // Node Class
        class Node {
            Customer customer;
            Node next;

            public Node(Customer customer) {
                this.customer = customer;
                this.next = null;
            }
        }

        //Queue Implementation
        class CustomQueue {
            private Node front;
            private Node rear;

            public CustomQueue() {
                this.front = null;
                this.rear = null;
            }
            //Customer (end) queue
            public void enqueue(Customer customer) {
                Node newNode = new Node(customer);
                if (rear == null) {
                    front = rear = newNode;
                } else {
                    rear.next = newNode;
                    rear = newNode;
                }
            }


            //Customer (start) queue
            public Customer dequeue() {
                if (front == null) {
                    return null;
                }
                Node temp = front;
                front = front.next;
                if (front == null) {
                    rear = null;
                }
                return temp.customer;
            }
            //check if queue is empty
            public boolean isEmpty() {
                return front == null;
            }
        }

        //Program 6 - The Customers
        String[] customerNames = {"Osiris Wang", "Dorian Morris", "Presley Robles","Collins Burke","Hayden Greene", "Malik Baxter", "Ryann Wiley", "Briggs Thomas", "Reuben Peterson", "Lara McKinney"};

        Customer[] customers = new Customer[10];
        //Creates accounts in customerNames
        for (int i = 0; i < 10; i++) {
            customers[i] = new Customer(customerNames[i]);
            customers[i].deposit(1000);
        }
        //New Queue
        CustomQueue queue = new CustomQueue();
        for (Customer customer : customers) {
            queue.enqueue(customer);
        }


        //Filewriter
        try (FileWriter writer = new FileWriter("customerAccounts.txt")) {
            while (!queue.isEmpty()) {
                Customer customer = queue.dequeue();

                // Print the account details to the console
                //System.out.println(customer.toString());

                // Write the account details to the file
                writer.write(customer.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        /*
        //Program 5 -- Checking Accounts
        // Create Stack for CheckingAccount and SavingAccount
        Stack<Checking> checkingStack = new Stack<>();
        Stack<SavingsAccount> savingStack = new Stack<>();

        // Create and push 25 CheckingAccount objects onto the checkingStack
        for (int i = 1; i <= 25; i++) {
            long checkingAccountNumber = generateAccountNumber();
            Checking checkingAccount = new Checking(String.valueOf(checkingAccountNumber), "Anthony Talavera",2000);
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
        private static long generateAccountNumber () {
            Random random = new Random();
            return 100000000000L + (long) (random.nextDouble() * 900000000000L);
        }

        */
    }
}
