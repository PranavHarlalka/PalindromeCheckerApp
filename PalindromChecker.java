/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class runs multiple palindrome algorithms on the
 * same input and measures execution time of each using
 * System.nanoTime() to compare their performance.
 *
 * Flow:
 * 1. Run multiple algorithms on same input
 * 2. Capture execution time using System.nanoTime()
 * 3. Display results with timing
 *
 * Key Concepts:
 * - System.nanoTime() for precise timing
 * - Algorithm comparison across approaches
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromChecker {

    // -------------------------------------------------------
    // Algorithm 1: Two-Pointer (char array)
    // -------------------------------------------------------
    static boolean twoPointer(String input) {
        char[] chars = input.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // -------------------------------------------------------
    // Algorithm 2: Stack-Based
    // -------------------------------------------------------
    static boolean stackBased(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++)
            stack.push(input.charAt(i));
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) != stack.pop()) return false;
        return true;
    }

    // -------------------------------------------------------
    // Algorithm 3: Queue + Stack
    // -------------------------------------------------------
    static boolean queueStack(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));
            stack.push(input.charAt(i));
        }
        while (!queue.isEmpty())
            if (queue.poll() != stack.pop()) return false;
        return true;
    }

    // -------------------------------------------------------
    // Algorithm 4: Deque-Based
    // -------------------------------------------------------
    static boolean dequeBased(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++)
            deque.addLast(input.charAt(i));
        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    // -------------------------------------------------------
    // Algorithm 5: Recursive
    // -------------------------------------------------------
    static boolean recursive(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursive(input, start + 1, end - 1);
    }

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("%-25s %-15s %s%n", "Algorithm", "Result", "Time (ns)");
        System.out.println("------------------------------------------------------");

        long start, end, duration;
        boolean result;

        // Algorithm 1: Two-Pointer
        start = System.nanoTime();
        result = twoPointer(input);
        end = System.nanoTime();
        duration = end - start;
        System.out.printf("%-25s %-15s %d ns%n", "Two-Pointer", result, duration);

        // Algorithm 2: Stack-Based
        start = System.nanoTime();
        result = stackBased(input);
        end = System.nanoTime();
        duration = end - start;
        System.out.printf("%-25s %-15s %d ns%n", "Stack-Based", result, duration);

        // Algorithm 3: Queue + Stack
        start = System.nanoTime();
        result = queueStack(input);
        end = System.nanoTime();
        duration = end - start;
        System.out.printf("%-25s %-15s %d ns%n", "Queue + Stack", result, duration);

        // Algorithm 4: Deque-Based
        start = System.nanoTime();
        result = dequeBased(input);
        end = System.nanoTime();
        duration = end - start;
        System.out.printf("%-25s %-15s %d ns%n", "Deque-Based", result, duration);

        // Algorithm 5: Recursive
        start = System.nanoTime();
        result = recursive(input, 0, input.length() - 1);
        end = System.nanoTime();
        duration = end - start;
        System.out.printf("%-25s %-15s %d ns%n", "Recursive", result, duration);

        System.out.println("------------------------------------------------------");

        scanner.close();
    }
}
