package CSCI_271.Assignments.Assignment_1;

import java.io.*;

/**
 * This class provides a method to count the frequency of word lengths in a text file.
 * It reads a file, processes its contents to count how many words exist of each length, and displays the counts.
 */
public class WordCounter {

    /**
     * The main method that initiates reading a file and counting word lengths.
     * It handles file operations and invokes methods to process text and display results.txt.
     *
     * @param args Command line arguments (not used here).
     */
    public static void main(String[] args) {

        BufferedReader reader = null;
        int[] output = new int[0]; // Initially an empty array

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("tester.txt")));
            String currentLine;

            System.out.println("File Contents: ");

            while((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
                String charsOnlyLine = currentLine.replaceAll("[^a-zA-Z0-9\\s]", "");
                String[] parsedLine = charsOnlyLine.split("\\s+");

                for (String s : parsedLine) {
                    int wordLen = s.length();
                    if (wordLen >= output.length) {
                        output = resizeOutputArray(output, wordLen);
                    }
                    output[wordLen]++;
                }
            }
            displayWordCounter(output);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Resizes an array used to count word lengths, ensuring there is enough space to record all lengths.
     *
     * @param output The original array of counts.
     * @param maxLength The maximum word length encountered that requires resizing the array.
     * @return The resized array with the same counts as before but additional space for larger lengths.
     */
    private static int[] resizeOutputArray(int[] output, int maxLength) {
        int[] temp_array = new int[maxLength + 1];

        for(int i = 0; i < output.length; i++) {
            temp_array[i] = output[i];
        }
        return temp_array;
    }

    /**
     * Displays the counts of word lengths from the provided array.
     *
     * @param array The array containing counts of words for each length.
     */
    private static void displayWordCounter(int[] array) {
        System.out.println("\nWord Length         Count");
        for(int i = 1; i < array.length; i++) {
            if (array[i] > 0) {  // Display only non-zero counts
                System.out.println(String.format("%5d%20d", i, array[i]));
            }
        }
    }
}
