package InterviewQA;

public class IsPalindram_usingStringBuffer {
    public static void main(String[] args) {
        String str = "abba";

        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        boolean isPalindram = strBuilder.toString().equals(str);

        if (isPalindram){
            System.out.println("String is palindram");
        } else {
            System.out.println("String is not palindram");
        }
    }
}
