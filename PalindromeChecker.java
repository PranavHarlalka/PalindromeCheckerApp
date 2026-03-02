/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using recursion. The method calls itself with a
 * smaller subproblem each time until the base condition
 * is reached.
 *
 * Flow:
 * 1. Recursive call compares start & end characters
 * 2. Base condition exits recursion
 * 3. Display result
 *
 * Key Concepts:
 * - Recursion (method calls itself)
 * - Base Condition (prevents infinite recursion)
 * - Call Stack (manages recursive method calls)
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.Scanner;

public class PalindromChecker {

    /**
     * Recursive method to check palindrome.
     * Compares characters at start and end positions,
     * moving inward with each recursive call.
     *
     * @param str   the input string
     * @param start starting index
     * @param end   ending index
     * @return true if palindrome, false otherwise
     */
    static boolean isPalindrome(String str, int start, int end) {

        // Base condition 1: single character or empty - always palindrome
        if (start >= end) {
            return true;
        }

        // If characters don't match - not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call - move inward
        return isPalindrome(str, start + 1, end - 1);
    }

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

        // Call recursive method
        boolean result = isPalindrome(input, 0, input.length() - 1);

        // Display result
        System.out.println("Input        : " + input);
        System.out.println("Is Palindrome: " + result);

        scanner.close();
    }
}
