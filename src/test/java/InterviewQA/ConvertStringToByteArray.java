package InterviewQA;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ConvertStringToByteArray {
    public static void main(String[] args) {
        // Convert String to Byte
        String str = "Testing";
        byte[] bytes = str.getBytes();
        System.out.println("String2Bytes: " + Arrays.toString(bytes));

        // Convert Byte to String
        byte[] bytes1 = {'T', 'E', 'S', 'T', 'I', 'N', 'G'};
        byte[] bytes2 = {83, 117, 114, 101, 115, 104};

        String str1 = new String(bytes1);
        String str2 = new String(bytes2);

        System.out.println("str1: " + str1 + " and str2: " + str2);
    }
}
