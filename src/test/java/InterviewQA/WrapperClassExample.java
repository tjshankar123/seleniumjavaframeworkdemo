package InterviewQA;

import java.util.ArrayList;

/*
In Java, a wrapper class is a class whose object encapsulates or "wraps" a primitive data type. This allows primitive values
(like int, char, boolean, float, double, byte, short, and long) to be treated as objects.
 */
public class WrapperClassExample {
    public static void main(String[] args) {
        // Autoboxing: int to Integer
        Integer num = 100;

        // Unboxing: Integer to int
        int primitiveNum = num;

        System.out.println("Wrapped Integer: " + num);
        System.out.println("Primitive int: " + primitiveNum);

        // Using wrapper class in a collection
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(20); // Autoboxing
        numbers.add(30);

        System.out.println("Numbers in ArrayList: " + numbers);

        // Using utility method
        String strNum = "456";
        int parsedNum = Integer.parseInt(strNum);
        System.out.println("Parsed number: " + parsedNum);
    }
}