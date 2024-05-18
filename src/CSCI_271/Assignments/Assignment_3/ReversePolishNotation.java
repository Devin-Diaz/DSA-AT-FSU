package CSCI_271.Assignments.Assignment_3;

public class ReversePolishNotation {
    public static void main(String[] args) {

        String s = args[0];
        System.out.println(convertToRPN(s));

    }
    public static String convertToRPN(String str) {
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        for(char c : str.toCharArray()) {
            if(isOperand(c)) {
                sb.append(c);
            }
            else if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if(!stack.isEmpty()) stack.pop();
            }
            else {
                while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
    public static boolean isOperand(char letter) {
        return Character.isLetterOrDigit(letter);
    }
    private static int getPriority(char operator) {
        if (operator == '(') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}
