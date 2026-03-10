/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates OOP principles by encapsulating
 * all palindrome logic inside a dedicated PalindromeService
 * class, exposing a single checkPalindrome() method.
 *
 * Flow:
 * 1. Create PalindromeService object
 * 2. Call checkPalindrome() method
 * 3. Display result
 *
 * Key Concepts (OOPS):
 * - Encapsulation: logic hidden inside a class
 * - Single Responsibility Principle: one class, one job
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.Scanner;

// -------------------------------------------------------
// Service Class - Encapsulates all palindrome logic
// -------------------------------------------------------
class PalindromeService {

    /**
     * Checks whether the given string is a palindrome.
     * Uses two-pointer approach internally.
     *
     * @param input the string to check
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {

        // Normalize: lowercase and remove spaces
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Two-pointer approach
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// -------------------------------------------------------
// Main Class - Entry point
// -------------------------------------------------------
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

        // Create PalindromeService object (Encapsulation)
        PalindromeService service = new PalindromeService();

        // Call checkPalindrome() method
        boolean result = service.checkPalindrome(input);

        // Display result
        System.out.println("Input        : " + input);
        System.out.println("Is Palindrome: " + result);

        scanner.close();
    }
}
