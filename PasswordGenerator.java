
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * A simple yet secure Password Generator.
 * Demonstrates: SecureRandom, StringBuilder, and basic CLI interaction.
 */

public class PasswordGenerator {
    // Character sets for password generation
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    // Combine all characters
    private static final String ALL_CHARS = LOWER + UPPER + DIGITS + SYMBOLS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Secure Password Generator ===");
        System.out.print("Enter desired password length: ");

        try {
            int length = scanner.nextInt();

            if (length < 4) {
                System.out.println("Error: Length must be at least 4 for basic security.");
            } else {
                String password = generatePassword(length);
                System.out.println("\nGenerated Password: " + password);
                System.out.println("Successfully generated a " + length + " character password.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a numerical value.");
        } finally {
            scanner.close();
        }
    }

    /**
     * Generates a random password of a given length.
     */
    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALL_CHARS.length());
            password.append(ALL_CHARS.charAt(randomIndex));
        }

        return password.toString();
    }
}