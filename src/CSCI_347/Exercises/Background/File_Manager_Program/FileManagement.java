package CSCI_347.Exercises.Background.File_Manager_Program;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Manages file operations related to storing and retrieving Student objects.
 * This class handles reading from and writing to text files, parsing student information,
 * and generating random student data.
 */
public class FileManagement {
    /**
     * Parses a text file to create a list of Student objects based on the contents of each line.
     * Each line in the file is expected to use ';' as a delimiter to separate student attributes: name, year, and GPA.
     *
     * @param fileName   The path to the text file to be parsed.
     * @param itemsRead  The maximum number of lines to read from the file.
     * @return           A list of Student objects read from the file.
     * @throws RuntimeException if an I/O error occurs.
     */
    public static List<Student> parseFile(String fileName, int itemsRead) {
        List<Student> allItemsRead = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            int count = 0;

            while((line = reader.readLine()) != null) {

                if(count == itemsRead) break;

                String[] parsedLine = line.split(";");
                String name = parsedLine[0];
                String year = parsedLine[1];
                double gpa = Double.parseDouble(parsedLine[2]);

                Student student = new Student(name, year, gpa);
                allItemsRead.add(student);
                count++;
            }
            reader.close();
            return allItemsRead;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a list of strings to a file, each string on a new line.
     *
     * @param location The file path where the data will be written.
     * @param inputs   The list of strings to write to the file.
     * @throws RuntimeException if an I/O error occurs.
     */
    public static void writeToFile(String location, List<String> inputs) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(location)));

            for(String input : inputs) {
                writer.write(input + "\n");
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generates a list of random student information in the correct format using delimiters.
     * The method leverages other static methods to generate random names, years, and GPAs.
     *
     * @param total The number of random student entries to generate.
     * @return      A list of formatted student information strings.
     */
    public static List<String> randomGeneratedStudentInfo(int total) {
        String[] names = RandomStudentGenerator.randomNameGenerator(total);
        String[] years = RandomStudentGenerator.randomYearGenerator(total);
        String[] gpa = RandomStudentGenerator.randomGpaGenerator(total);
        List<String> studentsList = new ArrayList<>();

        for(int i = 0; i < total; i++) {
            String line = names[i] + ";" + years[i] + ";" + gpa[i];
            studentsList.add(line);
        }
        return studentsList;
    }

    /**
     * Retrieves a random student from a list of student objects
     *
     * @param students      list that contains random generated students
     * @return              A random student from the list
     */
    public static Student generateRandomStudent(List<Student> students) {
        Random random = new Random();
        int len = students.size();
        return students.get(random.nextInt(len));
    }

    /**
     * Generates and writes random student data to a specified file.
     *
     * @param location         The file path where the data will be written.
     * @param amountOfStudents The number of random student entries to generate and write.
     */
    public static void generateRandomStudentsFile(String location, int amountOfStudents) {
        writeToFile(location, randomGeneratedStudentInfo(amountOfStudents));
    }

    /**
     * Prints each element of a list to the standard output, one element per line.
     *
     * @param arr The list of strings to be displayed.
     */
    public static void displayArray(List<String> arr) {
        for(String s : arr) {
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        //List<Student> output = parseFile("Enter file path here", Enter total items you want read);
        //Student randomStudentFromList = generateRandomStudent(output);

        //SearchingAlgorithms.linearSearch(output, randomStudentFromList);
        //SearchingAlgorithms.binarySearch(output, randomStudentFromList);
    }

}
