/*
Name: Anthony T
Date: 10.12.2024
Assignment: Program 6
 */

import java.io.*;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program6Test {

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

        // Queue Implementation
        class CustomQueue {
            private Node front;
            private Node rear;

            public CustomQueue() {
                this.front = null;
                this.rear = null;
            }

            // Customer (end) queue
            public void enqueue(Customer customer) {
                Node newNode = new Node(customer);
                if (rear == null) {
                    front = rear = newNode;
                } else {
                    rear.next = newNode;
                    rear = newNode;
                }
            }

            // Customer (start) queue
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

            // Check if queue is empty
            public boolean isEmpty() {
                return front == null;
            }
        }

        // Create a CustomQueue
        CustomQueue queue = new CustomQueue();

        // Read customer names from Accounts.txt
        File file = new File("Accounts.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String customerName = scanner.nextLine();

                // Create a new customer with the name read from the file
                Customer customer = new Customer(customerName);
                customer.deposit(1000); // Deposit $1000 to each account by default

                // Enqueue the customer
                queue.enqueue(customer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return; // Exit if file is not found
        }

        // FileWriter to write customer details to a file
        try (FileWriter writer = new FileWriter("customerAccounts.txt")) {
            while (!queue.isEmpty()) {
                Customer customer = queue.dequeue();

                // Print the account details to the console
                System.out.println(customer.toString()); // Ensure Customer has a proper toString() method

                // Write the account details to the file
                writer.write(customer.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
