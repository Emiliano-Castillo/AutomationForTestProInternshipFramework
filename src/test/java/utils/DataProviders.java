package utils;
import org.testng.annotations.DataProvider;
import java.security.SecureRandom;

public class DataProviders {

    static String currentEmail = "emiliano.castillo@testpro.io";
    static String currentPassword = "x]q}U&)2BH59O";
    static String oldPassword = "R_p65>g|8t3o]";

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {currentEmail, currentPassword}
        };
    }

    @DataProvider(name = "oldPasswordLoginData")
    public static Object[][] getOldPasswordData() {
        return new Object[][]{
                {currentEmail, oldPassword}
        };
    }

    @DataProvider(name = "registrationData")
    public static Object[][] newRegisterData() {
        return new Object[][] {
                {"emiliano.castillo+123@testpro.io"}
        };
    }

    @DataProvider(name = "profileData")
    public Object[][] getGeneratePassword() {
        return new Object[][]{
                {currentEmail, currentPassword, generateRandomPassword(13)}
        };
    }

    @DataProvider(name = "randomPasswordGenerator")
    public Object[][] generatePassword() {

        int numberOfPasswords = 1;
        int passwordLength = 10;

        Object[][] data = new Object[numberOfPasswords][1];

        for (int i = 0; i < numberOfPasswords; i++) {
            String randomPassword = generateRandomPassword(passwordLength);
            data[i][0] = randomPassword;
        }

        return data;
    }
    public String generateRandomPassword(int length) {
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

    @DataProvider(name = "searchData")
    public static Object[][] getSearchData() {
        return new Object[][]{
                {currentEmail, currentPassword, "Pluto"}
        };
    }

    @DataProvider(name = "searchArtistData")
    public static Object[][] getSearchArtistData() {
        return new Object[][]{
                {currentEmail, currentPassword, "Grav"}
        };
    }

    @DataProvider(name = "searchNonExistingSongNameData")
    public static Object[][] getNonExistingSongNameData() {
        return new Object[][]{
                {currentEmail, currentPassword, "We are family"}
        };
    }

    @DataProvider(name = "searchWhiteSpacesData")
    public static Object[][] getWhiteSpacesData() {
        return new Object[][]{
                {currentEmail, currentPassword, "Pluto    "},
                {currentEmail, currentPassword, "     Pluto"}
        };
    }

    @DataProvider(name = "searchCaseSensitiveData")
    public static Object[][] getCaseSensitiveData() {
        return new Object[][]{
                {currentEmail, currentPassword, "pluto"},
                {currentEmail, currentPassword, "PLUTO"}
        };
    }

    @DataProvider(name = "searchPressingESCKeyData")
    public static Object[][] getClearingData() {
        return new Object[][]{
                {currentEmail, currentPassword, "Pluto"}
        };
    }
}