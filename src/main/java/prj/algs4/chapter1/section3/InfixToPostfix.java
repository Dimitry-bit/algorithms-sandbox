/* Write a filter InfixToPostfix that converts an arithmetic expression from in-
fix to postfix. */

package prj.algs4.chapter1.section3;

import java.io.InputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InfixToPostfix {

    private static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    private static boolean isOperator(String token) {
        return switch (token) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }

    public static String toPostfix(String s) {
        StackResizingArray<String> opStack = new StackResizingArray<>();
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("(")) {
                opStack.push(token);
            } else if (token.equals(")")) {
                String pop;
                while (!opStack.isEmpty() && !((pop = opStack.pop()).equals("("))) {
                    sb.append(pop).append(' ');
                }
            } else if (isOperator(token)) {
                while (!opStack.isEmpty() && (precedence(token) <= precedence(opStack.peek()))) {
                    sb.append(opStack.pop()).append(' ');
                }
                opStack.push(token);
            } else {
                sb.append(token).append(' ');
            }
        }

        while (!opStack.isEmpty()) {
            sb.append(opStack.pop());

            if (!opStack.isEmpty()) {
                sb.append(' ');
            }
        }

        return sb.toString();
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
        String postfix = toPostfix(s);
        System.out.println(postfix);
    }
}
