package utils;
import org.testng.annotations.DataProvider;
import java.security.SecureRandom;

public class DataProviders {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a"}
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
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", generateRandomPassword(13)}
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

    @DataProvider(name = "searchData")
    public static Object[][] getSearchData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "Pluto"}
        };
    }

    @DataProvider(name = "searchArtistData")
    public static Object[][] getSearchArtistData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "Grav"}
        };
    }

    @DataProvider(name = "searchNonExistingSongNameData")
    public static Object[][] getNonExistingSongNameData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "We are family"}
        };
    }

    @DataProvider(name = "searchWhiteSpacesData")
    public static Object[][] getWhiteSpacesData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "Pluto    "},
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "     Pluto"}
        };
    }

    @DataProvider(name = "searchCaseSensitiveData")
    public static Object[][] getCaseSensitiveData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "pluto"},
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "PLUTO"}
        };
    }

    @DataProvider(name = "searchPressingESCKeyData")
    public static Object[][] getClearingData() {
        return new Object[][]{
                {"emiliano.castillo@testpro.io", "DSs2hQ}Hfl|(a", "Pluto"}
        };
    }
}