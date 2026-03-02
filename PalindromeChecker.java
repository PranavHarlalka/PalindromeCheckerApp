/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 2: Print a Hardcoded Palindrome Result
 *
 * Description:
 * This class takes a string input from the user and
 * checks whether it is a palindrome using a loop
 * that runs till half the string length.
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.Scanner;

public class PalindromChecker {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Assume it is a palindrome
        boolean isPalindrome = true;

        // Loop only till half the string length
        for (int i = 0; i < input.length() / 2; i++) {
            // Compare character from start with character from end
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Print true or false
        System.out.println(isPalindrome);

        scanner.close();
    }
}
