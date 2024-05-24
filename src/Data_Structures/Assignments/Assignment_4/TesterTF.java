package Data_Structures.Assignments.Assignment_4;

//Name: Devin Diaz
//Time: March. 10, 2024
//Class: Data Structures
//Instructor: Jeff Gao
/*Pledge: I, Devin Diaz, did not receive any help for this
programming assignment.*/

/*
    This program finds all the possibilities of n T/F questions.
    Given n T/F questions we know the amount of outcomes will
    be 2^n. This program finds all the outcomes of True and False

    e.g n = 2, outcomes = 4
    T T
    T F
    F T
    F F
*/
public class TesterTF {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        System.out.println("NUMBER OF QUESTIONS: " + n);

        System.out.println("ITERATIVE VERSION");
        TrueFalseOutcomes.iterativeVersion(n);

        System.out.println();
        System.out.println();

        System.out.println("RECURSIVE VERSION");
        TrueFalseOutcomes.recursiveVersion(n);
    }
}
