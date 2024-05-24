package General_Java_Exercises.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionProblems {

    // 1. Write a Java recursive method to calculate the factorial of a given positive integer.
    public static int factorial(int n) {
        if(n < 2) return n;
        return n * factorial(n - 1);
    }

    // 2. Write a Java recursive method to calculate the sum of all numbers from 1 to n.
    public static int sum(int n) {
        if(n == 1) return n;
        return n + sum(n - 1);
    }

    // 3. Write a Java recursive method to calculate the nth Fibonacci number.
    public static int fib(int n) {
        if(n < 2) return n;
        return factorial(n - 1) + factorial(n - 2);
    }

    // 4. Write a Java recursive method to check if a given string is a palindrome.
    public static boolean isPalindrome(String s) {
        if(s.length() <= 1) return true;
        char firstChar = s.charAt(0);
        char lastChar = s.charAt(s.length() - 1);
        if(firstChar != lastChar) return false;

        String remainingSubstring = s.substring(1, s.length() - 1);
        return isPalindrome(remainingSubstring);
    }

    // 5. Write a Java recursive method to calculate the exponentiation of a number (base) raised to a power (exponent).
    public static double exponentiation(double base, double exponent) {
        if(exponent == 0) return 1;
        return base * exponentiation(base, exponent - 1);
    }

    // 6. Write a Java recursive method to reverse a given string.
    public static String reverseString(String s, String prefix) {
        if(s.length() < 1) return prefix;
        char currentChar = s.charAt(s.length() - 1);
        String remainingString = s.substring(0, s.length() - 1);

        return reverseString(remainingString, prefix + currentChar);
    }

    // 7. Write a Java recursive method to find the greatest common divisor (GCD) of two numbers.
    public static int GCD(int x, int y) {
        if(y == 0) return x;
        int remainder = x % y;
        return GCD(y, remainder);
    }

    // 8. Write a Java recursive method to count the number of occurrences of a specific element in an array.
    public static int occurrences(int[] A, int index, int element) {
        if(index == A.length) return 0;
        int counter = occurrences(A, index + 1, element);

        if(A[index] == element) {
            counter++;
        }
        return counter;
    }

    // 9. Write a Java recursive method to find the sum of all odd numbers in an array.
    public static int sumOddsInArray(int[] A, int index) {
        if(index == A.length) return 0;
        int sum = sumOddsInArray(A, index + 1);

        if(A[index] % 2 == 1) {
            sum += A[index];
        }

        return sum;
    }

    // 10. Write a Java recursive method to find the length of a given string.
    public static int lengthOfString(String s) {
        if(s.length() <= 1) return 1;
        return 1 + lengthOfString(s.substring(1));
    }

    // 11. Write a Java recursive method to generate all possible permutations of a given string.
    public static List<String> permutationsOfString(String str) {
        List<String> output = new ArrayList<>();
        permutationsHelper(str, "", output);
        return output;
    }

    private static void permutationsHelper(String str, String current, List<String> output) {
        if(str.isEmpty()) {
            output.add(current);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permutationsHelper(remaining, current + currentChar, output);
        }
    }

    // 12. Write a Java recursive method to find the maximum element in an array.
    public static int maximumElement(int[] A) {
        return maximumElementHelper(A, A.length);
    }

    private static int maximumElementHelper(int[] A, int index) {
        if(index == 1) return A[0];
        return Math.max(A[index - 1], maximumElementHelper(A, index - 1));
    }

    // 13. Write a Java recursive method to calculate the product of all numbers in an array.
    public static int productOfArray(int[] A, int index) {
        if(index == A.length) return 1;

        int product = productOfArray(A, index + 1);
        product *= A[index];
        return product;
    }

    // 14. Write a Java recursive method to find the sum of the digits of a given integer.
    public static int digitSum(int num) {
        if(num < 1) return 0;
        return (num % 10) + digitSum(num / 10);
    }

    // 15. Write a Java recursive method to check if a given array is sorted in ascending order.
    public static boolean isSorted(int[] A, int index) {
        if(index == A.length - 1) return true;
        if(A[index] > A[index + 1]) return false;

        return isSorted(A, index + 1);
    }





}
