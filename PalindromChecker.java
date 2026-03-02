/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 7: Deque-Based Optimized Palindrome Checker
 *
 * Description:
 * This class uses a Deque (Double Ended Queue) to check
 * whether a string is a palindrome by comparing characters
 * from both the front and rear simultaneously.
 *
 * Flow:
 * 1. Insert all characters into the Deque
 * 2. Remove first & last characters simultaneously
 * 3. Compare until Deque is empty
 * 4. Display result
 *
 * Key Concepts:
 * - Deque (Double Ended Queue) - insert/delete from both ends
 * - Front and Rear Access for direct comparison
 * - Optimized - no separate reversal data structure needed
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.ArrayDeque;
import java.util.Deque;
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

        // Step 1: Insert all characters into the Deque
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        // Step 2 & 3: Remove first & last, compare until empty
        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear
            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Step 4: Display result
        System.out.println("Input        : " + input);
        System.out.println("Is Palindrome: " + isPalindrome);

        scanner.close();
    }
}
