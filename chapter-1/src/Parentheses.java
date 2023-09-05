import java.io.InputStream;
import java.util.Scanner;

public class Parentheses {

    private static char matchBracket(char c) {
        switch (c) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
        }

        assert (false);
        return '\0';
    }

    private static boolean isBalanced(String s) {
        StackResizingArray<Character> stack = new StackResizingArray<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (stack.isEmpty() || matchBracket(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return true;
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
        System.out.println(isBalanced(s));
    }
}