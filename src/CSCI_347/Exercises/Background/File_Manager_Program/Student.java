package CSCI_347.Exercises.Background.File_Manager_Program;

/**
 * Represents a student with a name, academic year, and GPA.
 * This class is used to model student data read from a text file and provides methods to access individual attributes.
 * It implements the Comparable interface to allow comparison based on the last name extracted from the full name.
 */
public class Student implements Comparable<Student> {
    private String name;
    private String year;
    private double gpa;

    /**
     * Constructs a new student with the specified name, academic year, and GPA.
     *
     * @param name the full name of the student
     * @param year the academic year of the student (e.g., "Freshman", "Sophomore", etc.)
     * @param gpa  the grade point average of the student
     */
    public Student(String name, String year, double gpa) {
        this.name = name;
        this.year = year;
        this.gpa = gpa;
    }

    /**
     * Returns the full name of the student.
     *
     * @return the full name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the academic year of the student.
     *
     * @return the academic year of the student
     */
    public String getYear() {
        return year;
    }

    /**
     * Returns the grade point average of the student.
     *
     * @return the grade point average of the student
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Provides a string representation of the student, formatted as "Name: [name], Year: [year], GPA: [gpa]".
     *
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Year: " + year + ", GPA: " + gpa;
    }

    /**
     * Compares this student with another student based on the last name.
     * This method is intended for use in sorting and other comparison contexts.
     *
     * @param other the student to be compared with this student
     * @return a negative integer, zero, or a positive integer as this student's last name
     *         is less than, equal to, or greater than the specified student's last name.
     */
    @Override
    public int compareTo(Student other) {
        String[] thisLastName = this.name.split("\\s");
        String[] otherLastName = other.name.split("\\s");

        return thisLastName[thisLastName.length - 1].compareTo(otherLastName[otherLastName.length - 1]);
    }

}
