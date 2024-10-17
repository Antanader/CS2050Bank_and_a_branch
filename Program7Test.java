/*
Name: Anthony T
Date: 10.16.2024
Assignment: Program7Test
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Program7Test {

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

        //Customers Names:
        CustomQueue queue = new CustomQueue();
        Customer[] customers = new Customer[10];
        File file = new File("accounts.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String customerName = scanner.nextLine(); // Assuming the format: just the name

                // Create a customer with just the name
                Customer customer = new Customer(customerName);

                // Enqueue the customer
                queue.enqueue(customer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return; // Exit the program if the file is not found
        }

        // Create a stack of accounts
        Stack<Customer> accountStack = new Stack<>();
        for (Customer customer : customers) {
            accountStack.push(customer);
        }

        //Number Generator
        Random random = new Random();

        //30 loops

        for (int i = 0; i < 30; i++) {
            Customer customer = queue.dequeue();
            //Assign an account if they don't
            if (Account.getAccountNumber() == null) {
                Customer accountFromStack = accountStack.pop();
                Objects.requireNonNull(customer).setAccountNumber(Account.getAccountNumber());
                customer.setBalance(accountFromStack.getBalance());
            }

            double randomValue = random.nextInt(1000) - 500; // Values between -500 and 500

            // check negative or positive
            if (randomValue > 0) {  // Deposit for positive
                Objects.requireNonNull(customer).deposit(randomValue);
                System.out.println("Action: " + (i + 1) + " " + customer.getAccountName() + " deposits: $" + randomValue);
            } else {  // Withdraw for negative or zero amounts
                Objects.requireNonNull(customer).withdraw(-randomValue);  // Withdraw
                System.out.println("Action: " + (i + 1) + " " + customer.getAccountName() + " withdraws: $" + -randomValue);
            }
            // Re-add the customer to the rear of the queue
            queue.enqueue(customer);
        }
        // Print the final details of each customer
        System.out.println("---------------------------");
        System.out.println("\nFinal Customer Details:");
        while (!queue.isEmpty()) { //if empty
            Customer customer = queue.dequeue();
            Objects.requireNonNull(customer).getAccount();
        }
    }
}

