/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates the Strategy Design Pattern by
 * defining a PalindromeStrategy interface and providing
 * multiple algorithm implementations (Stack, Deque).
 * The strategy is injected at runtime dynamically.
 *
 * Flow:
 * 1. Define PalindromeStrategy interface
 * 2. Implement StackStrategy and DequeStrategy
 * 3. Inject strategy at runtime based on user choice
 * 4. Display result
 *
 * Key Concepts (OOP + Design Patterns):
 * - Interface: defines the contract for all strategies
 * - Polymorphism: different strategies, same method call
 * - Strategy Pattern: algorithm selected at runtime
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

// -------------------------------------------------------
// Strategy Interface - Contract for all strategies
// -------------------------------------------------------
interface PalindromeStrategy {
    boolean check(String input);
}

// -------------------------------------------------------
// Strategy 1: Stack-Based Implementation (LIFO)
// -------------------------------------------------------
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Compare pop with original string
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// -------------------------------------------------------
// Strategy 2: Deque-Based Implementation
// -------------------------------------------------------
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        // Insert all characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        // Compare front and rear until empty
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// -------------------------------------------------------
// Context Class - Holds and executes the strategy
// -------------------------------------------------------
class PalindromeContext {

    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
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

        Scanner scanner = new Scanner(System.in);

        // Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Choose strategy at runtime
        System.out.println("Choose strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        // Inject strategy dynamically (Polymorphism)
        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
            System.out.println("Using: Stack Strategy");
        } else {
            strategy = new DequeStrategy();
            System.out.println("Using: Deque Strategy");
        }

        // Create context with chosen strategy
        PalindromeContext context = new PalindromeContext(strategy);

        // Execute and display result
        boolean result = context.execute(input);
        System.out.println("Input        : " + input);
        System.out.println("Is Palindrome: " + result);

        scanner.close();
    }
}
