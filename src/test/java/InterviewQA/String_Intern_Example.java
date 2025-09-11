package InterviewQA;

public class String_Intern_Example {
    public static void main(String[] args) {
        String s1 = new String("Hello"); // Creates a String object in heap
        String s2 = "Hello";                    // Creates/refers to a String literal in String Pool

        System.out.println(s1 == s2);           // false (different objects)

        String s3 = s1.intern();                // Interns "Hello" from heap into String Pool (or returns existing reference)
        System.out.println(s3 == s2);           // true (both now refer to the same object in the String Pool)
    }
}