package Analysis_Of_Algorithms.Exercises.Background.File_Manager_Program;

import java.util.Collections;
import java.util.List;

/**
 * Contains methods for searching student objects within a list using both linear and binary search algorithms.
 */
public class SearchingAlgorithms {

    /**
     * Performs a linear search on a list of students to find a specific student based on last name.
     * This method assumes that each student's name is a full name separated by spaces.
     *
     * @param list The list of Student objects to search through.
     * @param student The Student object containing the name to search for.
     */
    public static void linearSearch(List<Student> list, Student student) {
        String[] inputStudentLastName = student.getName().split("\\s");
        long startTime = System.nanoTime();

        for(Student stud : list) {
            String[] parsedLastName = stud.getName().split("\\s");
            if(inputStudentLastName[1].equals(parsedLastName[1])) {
                System.out.println("student found!");
                break;
            }
        }

        long endTime = System.nanoTime();
        long durationMicros = (endTime - startTime) / 1_000;
        System.out.println("Linear search took " + durationMicros + " microseconds.");
    }

    /**
     * Performs a binary search on a sorted list of students to find a specific student based on comparison criteria
     * defined in the Student's compareTo method. The list is sorted before performing the search.
     *
     * @param list The list of Student objects to search through.
     * @param student The Student object to find in the list.
     */
    public static void binarySearch(List<Student> list, Student student) {
        Collections.sort(list);
        int low = 0;
        int high = list.size() - 1;

        long startTime = System.nanoTime();
        while(low <= high) {
            int middle = low + (high - low) / 2;
            int res = list.get(middle).compareTo(student);

            if(res == 0) {
                System.out.println("student found!");
                break;
            } else if(res < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        long endTime = System.nanoTime();
        long durationMicros = (endTime - startTime) / 1_000;
        System.out.println("Binary search took " + durationMicros + " microseconds.");
    }
}
