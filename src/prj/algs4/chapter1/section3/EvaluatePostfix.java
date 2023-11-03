/* 1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard input, evaluates it, 
and prints the value. (Piping the output of your program from the previous exercise to this program gives equivalent behavior to Evaluate. */

package prj.algs4.chapter1.section3;

import java.io.InputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EvaluatePostfix {

    public static double evaluatePostfix(String postfix) {
        StringTokenizer st = new StringTokenizer(postfix);
        StackResizingArray<Double> operandStack = new StackResizingArray<Double>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("+")) {
                operandStack.push(operandStack.pop() + operandStack.pop());
            } else if (token.equals("-")) {
                double pop = operandStack.pop();
                operandStack.push(operandStack.pop() - pop);
            } else if (token.equals("*")) {
                operandStack.push(operandStack.pop() * operandStack.pop());
            } else if (token.equals("/")) {
                double pop = operandStack.pop();
                operandStack.push(operandStack.pop() / pop);
            } else {
                operandStack.push(Double.parseDouble(token));
            }
        }

        return operandStack.pop();
    }

    private static String readAll(InputStream source) {
        Scanner in = new Scanner(source);
        StringBuilder builder = new StringBuilder();
        while (in.hasNextLine()) {
            builder.append(in.nextLine());
        }
        in.close();
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = readAll(System.in);
        String postfix = InfixToPostfix.toPostfix(s);
        double val = evaluatePostfix(postfix);
        System.out.println(val);
    }
}
