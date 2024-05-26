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
import java.util.Collections;
import java.util.List;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public static void sortStrings(List<String> inputs) {
        System.out.println("Original list: " + inputs);
        inputs.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        System.out.println("Sorted list: " + inputs);
    }

    //6. Write a Java program to implement a lambda expression to find the average of a list of doubles.
    public static void averageOfDoubles(List<Double> inputs) {
        Double average = inputs.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println(average);
    }

    // 7. Write a Java program to implement a lambda expression to remove duplicates from a list of integers.
    public static void removeDuplicates(List<Integer> inputs) {
        List<Integer> outputs = inputs.stream()
                .distinct()
                .toList();
        System.out.println(outputs);
    }

    // 8. Write a lambda expression to implement a lambda expression to calculate the factorial of a given number.
    public static void factorial(Long n) {
        LongUnaryOperator fac = num -> {
            long result = 1;
            for(long i = 1; i <= num; i++) {
                result *= i;
            }
            return result;
        };
        long answer = fac.applyAsLong(n);
        System.out.println(answer);
    }

    // 9. Write a Java program to implement a lambda expression to create a lambda expression to check if a number is prime.












    public static void main(String[] args) {
        List<String> input = Arrays.asList("gO", "DEvin", "UP uP");
        List<Integer> nums = Arrays.asList(5, 2, 54, 654, 1, 3, 6, 0, 10);
        List<Double> dubs = Arrays.asList(5.5, 2.2, 54.0, 654.11, 1.3, 3.22, 6.42, 0.4, 10.0);
        List<Integer> listWithDups = Arrays.asList(1, 2, 3, 1, 4, 4, 56, 6, 56);

        LambdaProblems.sumTwoInts(10, 10);
        LambdaProblems.isStringEmpty("RAH");
        LambdaProblems.convertStringsToLower(input);
        LambdaProblems.filterEvensAndOdds(nums);
        LambdaProblems.sortStrings(input);
        LambdaProblems.averageOfDoubles(dubs);
        LambdaProblems.removeDuplicates(listWithDups);
        LambdaProblems.factorial(5L);


    }
}
