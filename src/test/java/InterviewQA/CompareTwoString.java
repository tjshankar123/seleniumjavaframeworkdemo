package InterviewQA;

public class CompareTwoString {
    public static void main(String[] args) {
        // Java String implements Comparable interface and it has two variants of CompareTo() methods.

        String str1 = "Hello";
        String str2 = "HEllo";

        if(str1.compareTo(str2) == 0) {
            System.out.println("str1 == str2");
        } else {
            System.out.println("str1 =! str2");
        }

        if (str1.compareToIgnoreCase(str2)==0){
            System.out.println("str1 == str2");
        } else {
            System.out.println("str1 =! str2");
        }

    }
}
