package CSCI_347.Exercises.Background.File_Manager_Program;

import java.util.Random;

/**
 * Generates random student data for simulations or testing.
 * This class provides methods to generate random names, academic years, and GPAs for a specified number of students.
 */
public class RandomStudentGenerator {

    // Arrays of possible first and last names for generating random full names
    static final String[] FIRST_NAMES = {
            "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Henry", "Isla", "Jack",
            "Kara", "Liam", "Mia", "Noah", "Olivia", "Parker", "Quinn", "Rose", "Sam", "Tina",
            "Uma", "Victor", "Wendy", "Xavier", "Yara", "Zane", "Amber", "Bruce", "Cindy", "Derek",
            "Eliza", "Fred", "Gina", "Harold", "Ivy", "Joel", "Katie", "Leo", "Megan", "Nate",
            "Oscar", "Penny", "Quincy", "Rachel", "Steve", "Terry", "Ursula", "Vince", "Willow", "Xena",
            "Yves", "Zelda", "Adam", "Beth", "Caleb", "Diana", "Ethan", "Fiona", "George", "Hanna",
            "Ian", "Julia", "Kyle", "Lana", "Max", "Nina", "Owen", "Paula", "Quinton", "Ruby",
            "Seth", "Tracy", "Uriah", "Valerie", "Wes", "Xander", "Yolanda", "Zeke", "April", "Ben",
            "Clara", "Dean", "Ella", "Felix", "Gemma", "Howard", "Ingrid", "Justin", "Krista", "Luke",
            "Monica", "Neil", "Opal", "Pat", "Queen", "Ron", "Sara", "Tim", "Ulysses", "Vera",
            "Walter", "Xyla", "Yasmine", "Zack"
    };

    static final String[] LAST_NAMES = {
            "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Henry", "Isla", "Jack",
            "Kara", "Liam", "Mia", "Noah", "Olivia", "Parker", "Quinn", "Rose", "Sam", "Tina",
            "Uma", "Victor", "Wendy", "Xavier", "Yara", "Zane", "Amber", "Bruce", "Cindy", "Derek",
            "Eliza", "Fred", "Gina", "Harold", "Ivy", "Joel", "Katie", "Leo", "Megan", "Nate",
            "Oscar", "Penny", "Quincy", "Rachel", "Steve", "Terry", "Ursula", "Vince", "Willow", "Xena",
            "Yves", "Zelda", "Adam", "Beth", "Caleb", "Diana", "Ethan", "Fiona", "George", "Hanna",
            "Ian", "Julia", "Kyle", "Lana", "Max", "Nina", "Owen", "Paula", "Quinton", "Ruby",
            "Seth", "Tracy", "Uriah", "Valerie", "Wes", "Xander", "Yolanda", "Zeke", "April", "Ben",
            "Clara", "Dean", "Ella", "Felix", "Gemma", "Howard", "Ingrid", "Justin", "Krista", "Luke",
            "Monica", "Neil", "Opal", "Pat", "Queen", "Ron", "Sara", "Tim", "Ulysses", "Vera",
            "Walter", "Xyla", "Yasmine", "Zack"
    };

    // Total length of the names arrays
    static final int LENGTH = FIRST_NAMES.length;

    // Array of academic year classifications
    static final String[] YEARS = {"Freshman", "Sophomore", "Junior", "Senior"};

    /**
     * Generates random full names by combining randomly selected first and last names.
     *
     * @param total The number of random names to generate.
     * @return An array of random full names.
     */
    public static String[] randomNameGenerator(int total) {
        Random random = new Random();
        String[] names = new String[total];

        for(int i = 0; i < names.length; i++) {
            names[i] = FIRST_NAMES[random.nextInt(LENGTH)] + " " + LAST_NAMES[random.nextInt(LENGTH)];
        }
        return names;
    }

    /**
     * Generates random academic years from a predefined list of year classifications.
     *
     * @param total The number of random academic years to generate.
     * @return An array of random academic years.
     */
    public static String[] randomYearGenerator(int total) {
        String[] years = new String[total];
        Random random = new Random();

        for(int i = 0; i < years.length; i++) {
            years[i] = YEARS[random.nextInt(YEARS.length)];
        }
        return years;
    }

    /**
     * Generates random GPA values ranging from 0.00 to 4.00, formatted to two decimal places.
     *
     * @param total The number of random GPA values to generate.
     * @return An array of formatted random GPA strings.
     */
    public static String[] randomGpaGenerator(int total) {
        String[] gpa = new String[total];
        Random random = new Random();

        for(int i = 0; i < gpa.length; i++) {
            double val = random.nextDouble() * 4.00;  // Ensures range is from 0.00 to 4.00
            String formattedValue = String.format("%.2f", val);  // Formats to two decimal places
            gpa[i] = formattedValue;
        }
        return gpa;
    }

}
