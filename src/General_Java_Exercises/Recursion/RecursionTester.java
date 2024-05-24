package General_Java_Exercises.Recursion;
public class RecursionTester {
    public static void main(String[] args) {
        int[] x = {1, 3, 5, 7};
        int[] arr = {1, 2, 2, 3, 2};
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(RecursionProblems.factorial(4));
        System.out.println(RecursionProblems.sum(4));
        System.out.println(RecursionProblems.fib(2));
        System.out.println(RecursionProblems.isPalindrome("racecar"));
        System.out.println(RecursionProblems.exponentiation(2, 3));
        System.out.println(RecursionProblems.reverseString("Java, World!", ""));
        System.out.println(RecursionProblems.GCD(10, 15));
        System.out.println(RecursionProblems.occurrences(arr, 0, 2));
        System.out.println(RecursionProblems.sumOddsInArray(A, 0));
        System.out.println(RecursionProblems.lengthOfString("hello"));
        System.out.println(RecursionProblems.permutationsOfString("ABC"));
        System.out.println(RecursionProblems.maximumElement(A));
        System.out.println(RecursionProblems.productOfArray(x, 0));
        System.out.println(RecursionProblems.digitSum(123456));
        System.out.println(RecursionProblems.isSorted(A, 0));
    }
}
