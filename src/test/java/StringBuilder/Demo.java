package StringBuilder;

public class Demo {
    // StringBuilder class provide alternative to String class and it is mutable.
    // StringBuilder performance is faster than StringBuffer because of no overhead of synchronization.

    // The main difference between StringBuffer and StringBuilder is that StringBuffer is thread-safe
    // due to synchronization and this is slower.

    public static void main(String[] argv) throws Exception
    {
        // Create a StringBuilder object
        // using StringBuilder() constructor
        StringBuilder str = new StringBuilder();

        str.append("GFG");

        // print string
        System.out.println("String = " + str.toString());

        // create a StringBuilder object
        // using StringBuilder(CharSequence) constructor
        StringBuilder str1 = new StringBuilder("AAAABBBCCCC");

        // print string
        System.out.println("String1 = " + str1.toString());

        // create a StringBuilder object
        // using StringBuilder(capacity) constructor
        StringBuilder str2 = new StringBuilder(10);

        // print string
        System.out.println("String2 capacity = "
                + str2.capacity());

        // create a StringBuilder object
        // using StringBuilder(String) constructor
        StringBuilder str3 = new StringBuilder(str1.toString());

        // print string
        System.out.println("String3 = " + str3.toString());

        // Comparing two strings.
        if(str1.compareTo(str3) == 0) {
            System.out.println("compareTo: Str1 and Str3 are same.");
        }
    }
}
