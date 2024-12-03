package InterviewQA;

public class FindDuplicateCharFromString {

    public static void main(String[] args) {
    //    String str = "Hackerearth".toLowerCase();
        String str = "xYz".toLowerCase();

        char[] charArray = str.toCharArray();

        boolean isNotDuplicate = false;

        // Finding duplicate char in the string
        for (int i = 0; i < str.length(); i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < str.length(); j++) {
                if (charArray[i] == charArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println(charArray[i]);
                isNotDuplicate = true;
            }
        }
        if (!isNotDuplicate) {
            System.out.println("No duplicates are found.!!!");
        }
    }
}
