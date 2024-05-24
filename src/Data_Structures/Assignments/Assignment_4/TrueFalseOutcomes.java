package Data_Structures.Assignments.Assignment_4;

import java.util.LinkedList;
import java.util.Queue;

/*
    These functions find all the possibilities of n multiple choice questions.

     For the iterative version, we utilize the built-in Queue interface with
     a LinkedList implementation. On each iteration we check the size of the
     queue, and we remove each element and append a T and F to previous
     combinations, and then adding them as new Strings causing us to get to
     2^n possibilities which is the formula for finding all outcomes given
     n multiple choice questions.

     For the recursive version, we use a prefix String to keep track of each
     outcome. We make a binary tree figure as we recurse through each time
     because in the recursive function, we call that same function twice,
     causing the creation of a binary figure. In the end we would've called
     our function (2^n) * 2 times meaning we would get 2^n different outputs
     which would meet all of our possibilities.
*/

public class TrueFalseOutcomes {
    // iterative version
    public static void iterativeVersion(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for(int i = 0; i < n; i++) {
            int currentSize = queue.size();
            for(int j = 0; j < currentSize; j++) {
                String combination = queue.poll();
                queue.add(combination + "T");
                queue.add(combination + "F");
            }
        }
        for(String comb : queue) {
            System.out.println(comb);
        }
    }

    // recursive version with helper function for more readable code
    public static void recursiveVersion(int n) {
        recursiveHelper("", n);
    }
    private static void recursiveHelper(String combination, int n) {
        if(n == 0) System.out.println(combination);
        else {
            recursiveHelper(combination + "T", n - 1);
            recursiveHelper(combination + "F", n - 1);
        }
    }
}
