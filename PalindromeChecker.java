/**
 * ==========================================================
 * MAIN CLASS - PalindromChecker
 * ==========================================================
 *
 * Use Case 3: Palindrome Check Using String Reverse
 *
 * Description:
 * This class checks whether a string is a palindrome by
 * reversing it using a for loop and comparing it with
 * the original using the equals() method.
 *
 * Flow:
 * 1. Reverse string using loop
 * 2. Compare original and reversed
 * 3. Display result
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

        // Reverse the string using a for loop
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        // Compare original and reversed using equals()
        boolean isPalindrome = input.equals(reversed);

        // Display result
        System.out.println("Original : " + input);
        System.out.println("Reversed : " + reversed);
        System.out.println("Is Palindrome: " + isPalindrome);

        scanner.close();
    }
}
