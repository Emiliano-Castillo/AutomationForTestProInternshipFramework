package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.SecureRandom;

public class DataProviders {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "eqwb5V&13,#xU"}
        };
    }
    @DataProvider(name = "profileData")
    public Object[][] getGeneratePassword() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "eqwb5V&13,#xU", generateRandomPassword(13)}
        };
    }
    @DataProvider(name = "randomPasswordGenerator")
    public Object[][] generatePassword() {

        int numberOfPasswords = 1;  // Adjust as needed
        int passwordLength = 10;    // Adjust as needed

        Object[][] data = new Object[numberOfPasswords][1];

        for (int i = 0; i < numberOfPasswords; i++) {
            String randomPassword = generateRandomPassword(passwordLength);
            data[i][0] = randomPassword;
        }

        return data;
    }
    private String generateRandomPassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Password length must be at least 1");
        }
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        String SPECIAL_CHAR = "!@#$%&*()-_=+[]{}|;:'<>,.?/";
        String ALL_CHAR = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL_CHAR;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALL_CHAR.length());
            password.append(ALL_CHAR.charAt(randomIndex));
        }
        return password.toString();
    }
    @Test(dataProvider = "randomPasswordGenerator")
    public void testPassword(String newPassword) {
        System.out.println("New Password: " + newPassword);
        // Your test logic goes here
    }
}