package com.coffecode.helper;

/*
 * helper class to generate a random string / number
 */

public class RandomGenerator {
    private RandomGenerator() {
        throw new UnsupportedOperationException("utility class");
    }

    private static final java.util.Random RANDOM = new java.util.Random();

    public static String generateRandomString(int length) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = RANDOM.nextInt(alphaNumericString.length());
            builder.append(alphaNumericString.charAt(character));
        }
        return builder.toString();
    }

    public static int generateRandomNumber(int min, int max) {
        return RANDOM.nextInt((max - min + 1)) + min;
    }

    public static int generateRandomNumber(int max) {
        return generateRandomNumber(0, max);
    }

    public static int generateRandomNumber() {
        return generateRandomNumber(Integer.MAX_VALUE);
    }

}
