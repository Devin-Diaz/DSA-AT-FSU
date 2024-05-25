package General_Java_Exercises.Lambda_Expressions;

/*
    Lambda expressions in Java provide a clear and concise way to represent one method interface using an expression.
    Useful in cases where you need to pass behavior as a method argument or when you want to create function objects.

    (parameter list) -> {body}
    if you only have a single parameter and expression, parentheses and brackets can be omitted.

    Every Lambda expression is matched to a single method interface known as a functional interface. A functional
    interface has exactly one abstract method.

    Lambdas provide a powerful, yet clear mechanism for creating instances of functional interfaces quickly
    using expressive, concise syntax.
*/

import General_Java_Exercises.Lambda_Expressions.Functional_Interfaces.SumCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaProblems {

    // 1. Write a Java program to implement a lambda expression to find the sum of two integers.
    public static void sumTwoInts(int num1, int num2) {
        SumCalculator sumCalculator = (x, y) -> x + y;
        int result = sumCalculator.sum(num1, num2);
        System.out.println(result);
    }

    // 2. Write a Java program to implement a lambda expression to check if a given string is empty.
    public static void isStringEmpty(String word) {
        Predicate<String> predicate = str -> str.isEmpty();
        boolean ans = predicate.test(word);
        System.out.println(ans);
    }

    // 3. Write a Java program to implement a lambda expression to convert a list of strings to lowercase.
    public static void convertStringsToLower(List<String> input) {
        System.out.println("\nOriginal word set: ");
        for(String s : input) {
            System.out.print(s + ", ");
        }

        input.replaceAll(str -> str.toLowerCase());

        System.out.println("\n\nLowercase word set:");
        for(String s : input) {
            System.out.print(s + ", ");
        }
        System.out.println("\n");
    }

    // 4. Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
    public static void filterEvensAndOdds(List<Integer> inputs) {
        System.out.println("Original nums: " + inputs);

        List<Integer> evenNumbers = inputs.stream()
                .filter(num -> num % 2 == 0)
                .toList();

        List<Integer> oddNumbers = inputs.stream()
                .filter(num -> num % 2 != 0)
                .toList();

        System.out.println("Even ints: " + evenNumbers);
        System.out.println("Odd ints: " + oddNumbers);
    }

    // 5. Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.
    














    public static void main(String[] args) {
        LambdaProblems.sumTwoInts(10, 10);
        LambdaProblems.isStringEmpty("RAH");

        List<String> input = Arrays.asList("gO", "DEvin", "UP uP");
        LambdaProblems.convertStringsToLower(input);

        List<Integer> nums = Arrays.asList(5, 2, 54, 654, 1, 3, 6, 0, 10);
        LambdaProblems.filterEvensAndOdds(nums);


    }
}
