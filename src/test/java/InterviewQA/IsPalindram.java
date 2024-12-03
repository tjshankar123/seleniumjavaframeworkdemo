package InterviewQA;

public class IsPalindram {
    public static void main(String[] args) {
        String str = "abba" ;
        boolean isPalindram = true;

        if (str.isBlank()) {
            System.out.println("String is null.");
        } else {
            int length = str.length();
            for(int i=0; i<length/2; i++) {
                if (str.charAt(i) != str.charAt(length-i-1)) {
                    isPalindram = false;
                }
            }
            if (isPalindram) {
                System.out.println("String is palindram");
            } else {
                System.out.println("String is not palindram");
            }
        }


    }
}

