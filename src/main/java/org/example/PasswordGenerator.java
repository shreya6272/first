package org.example;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

public class PasswordGenerator {
    private static final String CHAR_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGIT = "0123456789";
    private static final String SPECIAL = "_$#%" ;
    private static final int PASSWORD_LENGTH = 8;
    private static final String PASSWORD_ALLOW = CHAR_UPPERCASE + DIGIT + SPECIAL;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        generateStrongPassword();
    }

    public static String generateStrongPassword() {
        StringBuilder result = new StringBuilder(PASSWORD_LENGTH);

        String strUppercaseCase = generateRandomString(CHAR_UPPERCASE, 2);
        System.out.format("%-20s: %s%n", "Chars (Uppercase)", strUppercaseCase);
        result.append(strUppercaseCase);

        String strDigit = generateRandomString(DIGIT, 4);
        System.out.format("%-20s: %s%n", "Digits", strDigit);
        result.append(strDigit);

        String strSpecialChar = generateRandomString(SPECIAL, 2);
        System.out.format("%-20s: %s%n", "Special chars", strSpecialChar);
        result.append(strSpecialChar);

        String password = result.toString();
        System.out.format("%-20s: %s%n", "Final Password", shuffleString(password));
        System.out.format("%-20s: %s%n%n", "Password Length", password.length());
        return password;
    }

    private static String generateRandomString(String input, int size) {
        if (input == null || input.length() <= 0)
            throw new IllegalArgumentException("Invalid input.");
        if (size < 1) throw new IllegalArgumentException("Invalid size.");
        StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }
        return result.toString();
    }

    public static String shuffleString(String input) {
        List<String> result = Arrays.asList(input.split(""));
        Collections.shuffle(result);
        return result.stream().collect(Collectors.joining());
    }
}
