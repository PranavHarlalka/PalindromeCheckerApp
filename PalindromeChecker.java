/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a Singly Linked List. It uses the Fast & Slow
 * pointer technique to find the middle, reverses the
 * second half in-place, then compares both halves.
 *
 * Flow:
 * 1. Convert string to linked list
 * 2. Find middle using fast & slow pointers
 * 3. Reverse second half in-place
 * 4. Compare both halves
 * 5. Display result
 *
 * Key Concepts:
 * - Singly Linked List with Node references
 * - Node Traversal using next references
 * - Fast & Slow Pointer Technique to find middle
 * - In-Place Reversal of second half
 *
 * @author Pranav Harlalka
 * @version 1.0
 */

import java.util.Scanner;

public class PalindromChecker {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
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

        // Step 1: Convert string to linked list
        Node head = null;
        Node tail = null;

        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Find middle using fast & slow pointer technique
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // moves 1 step
            fast = fast.next.next;   // moves 2 steps
        }
        // slow is now at the middle

        // Step 3: Reverse the second half in-place
        Node prev = null;
        Node curr = slow;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        // prev is now the head of reversed second half

        // Step 4: Compare both halves
        Node left = head;
        Node right = prev;
        boolean isPalindrome = true;

        while (right != null) {
            if (left.data != right.data) {
                isPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        // Step 5: Display result
        System.out.println("Input        : " + input);
        System.out.println("Is Palindrome: " + isPalindrome);

        scanner.close();
    }
}
