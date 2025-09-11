package interviewQA;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommonlyAskedJavaPrograms {

    public static void main(String[] args) {

        int[] arr = {10,20,30,5, 5};
        CommonlyAskedJavaPrograms test = new CommonlyAskedJavaPrograms();
        test.reverseString("Hello");
        test.checkPalindram("madam");
        test.factorial(3);
        test.fibonacci(10);
        test.primeNumberCheck(13);
        test.largestElementInArray(arr);
        test.countVowelsInString("WelcomE");
        test.Is_ArmstrongNumber(9474);
        test.Is_ArmstrongNumber(153);
        test.Is_ArmstrongNumber(154);
        test.removeDuplicateFromArray(arr);
        test.sortArray(arr);

    }

    public void reverseString(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("reverseString: " + reversed);
    }

    public void checkPalindram(String str) {
        String reverseString = new StringBuilder(str).reverse().toString();
        System.out.println("checkPalindram: "+ str.equals(reverseString));
    }

    public void factorial(int num) {
        // fact(4) = 1*2*3*4
        int fact = 1;

        for(int i=1; i<=num; i++) {
            fact *= i;
        }
        System.out.println("factorial: " + fact);
    }

    public void fibonacci(int num) {
        int firstTerm = 0;
        int secondTerm = 1;

        for (int i=0; i<num; i++) {
            System.out.print(firstTerm + " ");
            int temp = firstTerm + secondTerm;
            firstTerm= secondTerm;
            secondTerm = temp;
        }
        System.out.println();
    }

    public void primeNumberCheck(int num) {
        int count = 0;

        for(int i=2; i<=num/2; i++) {
            if(num%i==0) {
                count++;
            }
        }

        System.out.println("Prime number: " + (count==0 ? "Prime" : "Not Prime"));
    }

    public void largestElementInArray(int[] arr) {
        int max = arr[0];

        // Enhanced version of for loop for arrays or collection.
        for (int i:arr) {
            if (i>max) {
                max = i;
            }
        }
        System.out.println("Largest: " + max);

    }

    public void countVowelsInString(String str) {
        int count = 0;

        for(char ch: str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch)!=-1) {
                count++;
            }
        }
        System.out.println("Vowels count: " + count);
    }

    public void Is_ArmstrongNumber(int num) {
        /*
         *  An Armstrong number (also known as a narcissistic number) is a number that is equal to the sum of its
         *  own digits each raised to the power of the number of digits.
         */
        int sum = 0;
        int original = num;
        int numOfDigits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, numOfDigits);
            num /= 10;
        }

        if (sum == original) {
            System.out.println(original + " is an Armstrong Number.");
        } else {
            System.out.println(original + " is NOT an Armstrong Number.");
        }

    }

    public void removeDuplicateFromArray(int [] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i:arr) {
            set.add(i);
        }

        System.out.println("Remove duplicate array: " + set);

    }

    public void sortArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Ascending Sorted Array is: " + Arrays.toString(arr));

    }
}