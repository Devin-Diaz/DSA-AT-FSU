package General_Java_Exercises.Exception_Handling;

public class ExceptionTester {
    public static void main(String[] args) {
        ExceptionProblems.divideNumbers(10, 0);
        ExceptionProblems.isEven(9);
        ExceptionProblems.isFileFound("hello.txt");
        ExceptionProblems.testFileForNegatives("negative-numbers.txt");
        ExceptionProblems.checkFileForDuplicates("dups.txt");
        ExceptionProblems.doesWordContainVowel("ymb");
    }
}


