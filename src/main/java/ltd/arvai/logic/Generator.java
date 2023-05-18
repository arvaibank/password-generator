package ltd.arvai.logic;

import java.security.SecureRandom;

public class Generator {
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";

    public String generatePassword(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();

        if (length < 3) {
            String combinedChars = LOWER_CASE + UPPER_CASE + NUMBERS;
            for (int i = 0; i < length; i++) {
                sb.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
            }
            return sb.toString();
        } else {
            // Generate at least one lowercase letter
            sb.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));

            // Generate at least one uppercase letter
            sb.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));

            // Generate at least one number
            sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

            // Generate remaining characters
            int remainingLength = length - 3; // subtract 3 for the already generated characters
            String combinedChars = LOWER_CASE + UPPER_CASE + NUMBERS;
            for (int i = 0; i < remainingLength; i++) {
                sb.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
            }

            // Shuffle the generated password
            String password = sb.toString();
            char[] passwordArray = password.toCharArray();
            for (int i = 0; i < passwordArray.length; i++) {
                int randomIndex = random.nextInt(passwordArray.length);
                char temp = passwordArray[i];
                passwordArray[i] = passwordArray[randomIndex];
                passwordArray[randomIndex] = temp;
            }
            return new String(passwordArray);
        }
    }

}
