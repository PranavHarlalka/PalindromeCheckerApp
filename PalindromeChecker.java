/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 6: Queue + Stack Based Palindrome Check
 *
 * Description:
 * This class uses both a Queue (FIFO) and a Stack (LIFO)
 * to validate whether a string is a palindrome.
 * Characters are enqueued and pushed simultaneously,
 * then dequeued and popped for comparison.
 *
 * Flow:
 * 1. Enqueue all characters into Queue
 * 2. Push all characters into Stack
 * 3. Compare dequeue (FIFO) vs pop (LIFO)
 * 4. Display result
 *
 * Key Concepts:
 * - Queue (FIFO - First In First Out) using LinkedList
 * - Stack (LIFO - Last In First Out)
 * - Enqueue & Dequeue operations
 * - Stack vs Queue behavioral difference
 * - Logical comparison of both outputs
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.LinkedList;
import java.util.Queue;
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

        // Step 1: Enqueue and Push all characters
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));   // Enqueue (FIFO)
            stack.push(input.charAt(i));  // Push (LIFO)
        }

        // Step 2: Compare dequeue (front) vs pop (top)
        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) {  // dequeue vs pop
                isPalindrome = false;
                break;
            }
        }

        // Step 3: Display result
        System.out.println("Input        : " + input);
        System.out.println("Is Palindrome: " + isPalindrome);

        scanner.close();
    }
}
