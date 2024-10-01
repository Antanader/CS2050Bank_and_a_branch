/*
Name: Anthony Talavera
Date: 9.30.2024
Program: Stack Class
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


//Class Declaration
public class Stack<A> {

    //Stack Array
    private ArrayList<A> stack;

    //Creating Stack Constructor
    public Stack() {
        stack = new ArrayList<>();
    }

    //Pushing to Stack (top)
    public void push(A item) {
        stack.add(item);
    }


    //Removing and returning top element of stack
    public A pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }


    //Check for empty stack
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    //Stack Size
    public int size() {
        return stack.size();
    }

    //writes stack to file
    public void writeStackToFile(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (A item : stack) {
                writer.write(item.toString() + "\n");
            }
        }
    }

    public void printStackContents() {
        if (stack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            for (A item : stack) {
                System.out.println(item);
            }
        }
    }
}
