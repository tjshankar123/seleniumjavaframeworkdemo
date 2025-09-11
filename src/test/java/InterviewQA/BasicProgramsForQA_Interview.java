package InterviewQA;

import java.util.Arrays;
import java.util.Vector;

public class BasicProgramsForQA_Interview {
    // 1. Palindrome Check
    public boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversedStr);
    }

    // 2. Factorial Calculation
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 3. Prime Number Check
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 4. Fibonacci Series
    public void printFibonacciSeries(int count) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series (first " + count + " numbers): ");
        for (int i = 0; i < count; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println();
    }

    // 5. Swap Two Numbers without a third variable
    public void swapNumbers(int a, int b) {
        System.out.println("Before swapping: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }

    // 6. Find Largest of Three Numbers
    public int findLargest(int a, int b, int c) {
        return Math.max(a,Math.max(b, c));
    }

    // 7. Reverse a String
    public String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    //8. Count Vowels in a String
    public int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // 9. Check if a String is an Anagram
    //a word, phrase, or name formed by rearranging the letters of another
    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);
        return java.util.Arrays.equals(charArray1, charArray2);
    }

    // 10. Remove Duplicates from a String
    public String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (result.indexOf(String.valueOf(str.charAt(i))) == -1) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    // 11. Reverse individual word in sentence
    public String reverseWords(String str){
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            result.append(reversedWord).append(" ");
        }
        return result.toString().trim();
    }

    // 12. Reverse individual word in sentences
    public String reverseWordsInSentences(String str) {
        String[] sentences = str.split("\\.");
        StringBuilder result = new StringBuilder();
        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            StringBuilder reversedSentence = new StringBuilder();
            for (String word : words) {
                StringBuilder reversedWord = new StringBuilder(word).reverse();
                reversedSentence.append(reversedWord).append(" ");
            }
            result.append(reversedSentence.toString().trim()).append(". ");
        }
        return result.toString().trim();
    }


    // 13. Count the occurrence of word in sentence
    public int countWordInSentence (String sentence, String word){
        int count = 0;
        sentence = sentence.replaceAll("\\.", "");
        sentence = sentence.replaceAll("\\,", "");

        String[] words = sentence.split(" ");
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }

    // 14. Arrays: Find duplicate
    public String findDuplicate(int[] arr){
        int[] duplicate = new int[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = java.util.Arrays.copyOf(duplicate, duplicate.length + 1);
                    duplicate[duplicate.length - 1] = arr[i];
                }
            }
        }
        return Arrays.toString(duplicate);
    }

    // 15. Arrays: Find Min and Max
    public String findMinAndMax(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return min +" and "+ max;
    }

    // 16. Collection: List example
    public void listExample(){
        /*
        Ordered Collection: Elements in a List maintain their insertion order. This means elements are stored and retrieved in the sequence they were added.
        Allows Duplicates: A List can contain multiple identical elements.
        Indexed Access: Elements can be accessed by their numerical index (position).
        Implementations: Common implementations include ArrayList, LinkedList, and Vector.
         */
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Apple"); // Duplicate allowed.
        System.out.println("Before remove\n" + list);
        list.remove("Banana");
        list.set(1, "Mango");
        System.out.println("After remove\n" + list);
    }

    // 17. Collection: Set example
    public void setExample(){
        /*
        Unordered Collection (generally): Set implementations typically do not guarantee any specific order of elements,
           except for LinkedHashSet which maintains insertion order, and TreeSet which stores elements in sorted order.
        No Duplicates: A Set enforces uniqueness; it cannot contain duplicate elements. If you attempt to add a duplicate,
           it will simply be ignored.
        No Indexed Access: Index cannot access elements as there is no guaranteed order.
        Implementations: Common implementations include HashSet, LinkedHashSet, and TreeSet.
         */
        java.util.Set<String> set = new java.util.HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
      //  set.add("Apple"); // Duplicate not allowed.
        System.out.println(set);
    }

    // 18. Collection - ArrayList
    public void ArrayListExample(){
    /*
        ArrayList is implemented using a dynamic array. When the internal array becomes full, a new, larger array is created,
        and the elements are copied to the new array.
     */
        System.out.println("\nArrayList\n");
        java.util.ArrayList<String> arrayList = new java.util.ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        System.out.println(arrayList);
        arrayList.remove(1);
        System.out.println(arrayList);
        arrayList.set(1, "Mango");
        System.out.println(arrayList);
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.size());
        System.out.println("is empty?: "+arrayList.isEmpty());
        System.out.println(arrayList.contains("Apple"));
        System.out.println(arrayList.contains("Grapes"));
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("After clear: "+arrayList.isEmpty());
    }

    public void LinkedListExample(){
        /*
        LinkedList is implemented as a doubly linked list, where each element (node) stores a reference to the previous and next elements.
         */
        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        System.out.println("\n LinkedList : "+linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.set(1, "Mango");
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.size());
        System.out.println("is empty?: "+linkedList.isEmpty());
        System.out.println(linkedList.contains("Apple"));
        System.out.println(linkedList.contains("Grapes"));
        linkedList.clear();
        System.out.println(linkedList);
        System.out.println("After clear: "+linkedList.isEmpty());

    }

    public void VectorListExample(){
        Vector<Double> temperatures = new Vector<>();
        temperatures.add(25.5);
        temperatures.add(28.0);
        System.out.println(temperatures.elementAt(0)); // Output: 25.5
        temperatures.removeElementAt(1);
        System.out.println(temperatures); // Output: [25.5]

    }

    public static void main(String[] args) {
        BasicProgramsForQA_Interview basicPrograms = new BasicProgramsForQA_Interview();

        System.out.println("Is Palindrome: " + basicPrograms.isPalindrome("madam"));
        System.out.println("Is Palindrome: " + basicPrograms.isPalindrome("Radar"));
        System.out.println("Factorial: " + basicPrograms.factorial(5));
        System.out.println("Is Prime: " + basicPrograms.isPrime(17));
        basicPrograms.printFibonacciSeries(10);
        basicPrograms.swapNumbers(5, 10);
        System.out.println("Largest of Three: " + basicPrograms.findLargest(10, 20, 15));
        System.out.println("Reversed String: " + basicPrograms.reverseString("hello"));
        System.out.println("Vowels Count: " + basicPrograms.countVowels("hello"));
        System.out.println("Is Anagram: " + basicPrograms.isAnagram("listen", "silent"));
        System.out.println("Duplicates Removed: " + basicPrograms.removeDuplicates("hello"));
        System.out.println("Reversed Words: " + basicPrograms.reverseWords("hello world"));
        System.out.println("Reversed Words in Sentences: " + basicPrograms.reverseWordsInSentences("Hello world. How are you?"));
        System.out.println("Word Count in Sentence: " + basicPrograms.countWordInSentence("Hello world. How are you?","world"));
        System.out.println("Min and Max: " + basicPrograms.findMinAndMax(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println("Duplicate: " + basicPrograms.findDuplicate(new int[]{1,2,3,4,5,5,6,6,7,8,9,10,1}));
        System.out.println("\n");
        basicPrograms.listExample();
        basicPrograms.setExample();
        basicPrograms.ArrayListExample();
        basicPrograms.LinkedListExample();
        basicPrograms.VectorListExample();

    }



}
