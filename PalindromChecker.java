/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by first normalizing it - converting to lowercase and
 * removing all spaces using regular expressions - then
 * applying the two-pointer palindrome logic.
 *
 * Flow:
 * 1. Normalize string (lowercase + remove spaces)
 * 2. Apply two-pointer palindrome logic
 * 3. Display result
 *
 * Key Concepts:
 * - String Preprocessing (normalize before checking)
 * - toLowerCase() for case-insensitive comparison
 * - Regular Expressions (replaceAll) to remove spaces
 * - Two-pointer logic for palindrome check
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

        // Step 1: Normalize the string
        // Convert to lowercase and remove all spaces using regex
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Step 2: Apply two-pointer palindrome logic
        int start = 0;
        int end = normalized.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Step 3: Display result
        System.out.println("Original     : " + input);
        System.out.println("Normalized   : " + normalized);
        System.out.println("Is Palindrome: " + isPalindrome);

        scanner.close();
    }
}
