package InterviewQA;

public class ConvertString2Array {
    public static void main(String[] args){
        String str = "Testing";

        char[] charArray = str.toCharArray();
        System.out.println("Number or characters: " + charArray.length);
        System.out.println("First letter: " + charArray[0]);

        // Without using char array
        System.out.println("First letter without using char array: " + str.charAt(0));



    }
}
