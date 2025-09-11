package Regex.util;

import java.util.regex.Pattern;

public class RegexValidator {
     private static final Pattern EMAIL_PATTERN =
             Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

     private static final Pattern PHONE_PATTERN =
                Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");

     private static final Pattern PASSWORD_PATTERN =
                Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");

     private static final Pattern POSTAL_CODE_PATTERN =
                Pattern.compile("^[A-Za-z]\\d[A-Za-z] \\d[A-Za-z]\\d$");

     public static boolean isValidEmail(String email) {
            return EMAIL_PATTERN.matcher(email).matches();
     }

    public static boolean isValidPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isStrongPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static boolean isValidPostalCode(String postalCode) {
        return POSTAL_CODE_PATTERN.matcher(postalCode).matches();
    }
}
