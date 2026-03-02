/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 4: Character Array Based Palindrome Check
 *
 * Description:
 * This class converts a string into a character array
 * and uses the two-pointer technique to check if it
 * is a palindrome by comparing start and end characters.
 *
 * Flow:
 * 1. Convert string to char[]
 * 2. Use two-pointer approach
 * 3. Compare start & end characters
 * 4. Display result
 *
 * Key Concepts:
 * - Character Array (char[]) for index-based access
 * - Array Indexing starting from 0
 * - Two-Pointer Technique (start & end pointers)
 * - Time Complexity Awareness (no extra objects created)
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

        // Step 1: Convert string to character array
        char[] chars = input.toCharArray();

        // Step 2: Two-pointer approach
        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        // Step 3: Compare start & end characters
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Step 4: Display result
        System.out.println("Input    : " + input);
        System.out.println("Is Palindrome: " + isPalindrome);

        scanner.close();
    }
}
