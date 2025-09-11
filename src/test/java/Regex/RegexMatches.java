package Regex;

import Regex.util.RegexValidator;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// https://www.tutorialspoint.com/javaregex/javaregex_capturing_groups.htm

public class RegexMatches {
    @Test
    public void captureGroups() {
        /*Capturing groups are numbered by counting their opening parentheses from the left to the right.*/

        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);

        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void emailValidation(){
        String email = "tharma@example.com";
        Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Valid email");
        } else {
            System.out.println("Invalid email");
        }
    }

    @Test
    public void phoneNumberValidation(){
        String phone = "(416) 930-3550";
      //  Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
        Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            System.out.println("Valid phone number");
        } else {
            System.out.println("Invalid phone number");
        }
    }

    @Test
    public void numericString(){
        String input = "123456";
        Pattern pattern = Pattern.compile("^\\d+$");
        System.out.println(pattern.matcher(input).matches()); // true
    }

    @Test
    public void passwordStrength(){
        String password = "StrongPass1";
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
        System.out.println(pattern.matcher(password).matches()); // true
    }

    @Test
    public void canadianPostalCodeValidation(){
        String postalCode = "M5V 3L9";
        Pattern pattern = Pattern.compile("^[A-Za-z]\\d[A-Za-z] \\d[A-Za-z]\\d$");
        System.out.println(pattern.matcher(postalCode).matches()); // true
    }

    @Test
    public void PatternSyntaxExceptionDemo(){
          String REGEX = "[";
          String INPUT = "The dog says meow " + "All dogs say meow.";
          String REPLACE = "cat";

        try{
            Pattern pattern = Pattern.compile(REGEX);

            // get a matcher object
            Matcher matcher = pattern.matcher(INPUT);
            INPUT = matcher.replaceAll(REPLACE);
        } catch(PatternSyntaxException e){
            System.out.println(e.getMessage());;
            System.out.println("===============================");
            System.out.println("PatternSyntaxException: ");
            System.out.println("Description: "+ e.getDescription());
            System.out.println("Index: "+ e.getIndex());
            System.out.println("Message: "+ e.getMessage());
            System.out.println("Pattern: "+ e.getPattern());
        }
    }

    @Test
    public void useUtilClass(){

        String email = "tj@gmail.com";
        String pwd = "abcefg";
        if (!RegexValidator.isValidEmail(email)) {
            System.out.println("Invalid email format");
            //return ResponseEntity.badRequest().body("Invalid email format");
        }
        if (!RegexValidator.isStrongPassword(pwd)) {
            System.out.println("Invalid password");
           // return ResponseEntity.badRequest().body("Weak password");
        }
    }
}
