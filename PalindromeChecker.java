/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 5: Stack-Based Palindrome Checker
 *
 * Description:
 * This class uses a Stack data structure to check whether
 * a string is a palindrome. Characters are pushed onto
 * the stack and then popped (LIFO) to naturally reverse
 * them for comparison.
 *
 * Flow:
 * 1. Push all characters into the stack
 * 2. Pop characters and compare with original
 * 3. Print result
 *
 * Key Concepts:
 * - Stack (LIFO - Last In First Out)
 * - Push Operation to insert characters
 * - Pop Operation to retrieve in reverse order
 * - Reversal Logic using Stack
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.Scanner;
import java.util.Stack;

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

        // Step 1: Push all characters into the stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Step 2: Pop characters and compare with original
        boolean isPalindrome = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Step 3: Print result
        System.out.println("Input        : " + input);
        System.out.println("Is Palindrome: " + isPalindrome);

        scanner.close();
    }
}
