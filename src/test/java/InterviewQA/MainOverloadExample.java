package InterviewQA;

public class MainOverloadExample {

    // The standard main method, which is the entry point for the JVM
    public static void main(String[] args) {
        System.out.println("This is the standard main method (String[] args).");

        // Calling the overloaded main methods
        main(10);
        main("Hello from overloaded main!");
    }

    // Overloaded main method with an integer parameter
    public static void main(int number) {
        System.out.println("Overloaded main method with int: " + number);
    }

    // Overloaded main method with a String parameter
    public static void main(String message) {
        System.out.println("Overloaded main method with String: " + message);
    }
}
