package InterviewQA;

import java.io.FileReader;
import java.io.IOException;

/*
Purpose: Used in conjunction with try-catch blocks to ensure a section of code is executed, regardless of whether an exception
occurred or not. It's often used for resource cleanup (e.g., closing files, database connections).
Usage: Always follows a try block and can optionally follow catch blocks.
 */

public class FinallyExample {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("example.txt");
            // ... process file ...
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close(); // Ensure resource is closed
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
            System.out.println("Finally block executed.");
        }
    }
}