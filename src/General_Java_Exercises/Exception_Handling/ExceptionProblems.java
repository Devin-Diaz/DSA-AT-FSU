package General_Java_Exercises.Exception_Handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExceptionProblems {

    // 1. Write a Java program that throws an exception and catch it using a try-catch block.
    private static int divideNumsHelper(int dividend, int divisor) {
        if(divisor == 0) throw new ArithmeticException("CANNOT DIVIDE BY 0!!!");
        return dividend / divisor;
    }
    public static void divideNumbers(int x, int y) {
        try {
            System.out.println(divideNumsHelper(x, y));
        } catch (ArithmeticException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // 2. Write a Java program to create a method that takes an integer as a parameter and throws an exception if the number is odd.
    private static boolean isEvenChecker(int n) {
        if(n % 2 == 1) throw new IllegalArgumentException("NUMBER MUST BE EVEN!!!");
        return true;
    }

    public static void isEven(int n) {
        try {
            System.out.println(isEvenChecker(n));
        } catch(IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //3. Write a Java program to create a method that reads a file and throws an exception if the file is not found.
    private static void fileNotFoundHelper(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }

        sc.close();
    }
    public static void isFileFound(String fileName) {
        try {
            fileNotFoundHelper(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // 4. Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers are positive.
    private static boolean isNegative(int n) {
        return n < 0;
    }
    private static void checkFileForNegatives(String fileName) throws FileNotFoundException {
        System.out.println("CONTENTS OF " + fileName);
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int counter = 1;

        while(sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            int currentNum = Integer.parseInt(currentLine);
            System.out.println(currentNum);
            if(!isNegative(currentNum))
                throw new IllegalArgumentException("FOUND POSITIVE NUMBER ON LINE: " + counter);

            counter++;
        }
        System.out.println("\n" + fileName + " HAS ALL NEGATIVE NUMBERS!");
    }
    public static void testFileForNegatives(String fileName) {
        try {
            checkFileForNegatives(fileName);
        } catch(IllegalArgumentException | FileNotFoundException e) {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    // 5. Write a Java program that reads a file and throws an exception if the file is empty.
    // --> would check if the nextLine length is greater than 0.


    // 6. Write a Java program that reads a list of integers from the user and throws an exception if any numbers are duplicates.
    private static void duplicateChecker(String fileName) throws FileNotFoundException {
        System.out.println("CONTENTS OF " + fileName);
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        Set<Integer> set = new HashSet<>();

        while(sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            int currentNum = Integer.parseInt(currentLine);
            System.out.println(currentNum);
            if(set.contains(currentNum))
                throw new IllegalArgumentException("CONTAINS DUPLICATE: " + currentNum);

            set.add(currentNum);
        }
        System.out.println("\nALL NUMBERS ARE UNIQUE!");
    }
    public static void checkFileForDuplicates(String fileName) {
        try {
            duplicateChecker(fileName);
        } catch(IllegalArgumentException | FileNotFoundException e) {
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    // 7. Write a Java program to create a method that takes a string as input and throws an exception if the string does not contain vowels.
    private static boolean containsVowel(String str) {
        String checker = str.replaceAll("[^aeiou]", "");
        if(checker.length() == 0) throw new IllegalArgumentException(str + " DOES NOT CONTAIN VOWEL!!!");
        return true;
    }
    public static void doesWordContainVowel(String str) {
        try {
            System.out.println(containsVowel(str));
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

}


