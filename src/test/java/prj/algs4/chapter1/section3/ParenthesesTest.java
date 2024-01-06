package prj.algs4.chapter1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParenthesesTest {

    @Test
    public void parentheses_isBalanced_shouldReturnTrue() {
        String s = "([{}])";

        boolean isBalanced = Parentheses.isBalanced(s);

        Assertions.assertTrue(isBalanced);
    }

    @Test
    public void parentheses_isBalanced_shouldReturnFalse() {
        String[] scenarios = new String[] {
                "(",
                ")",
                "[",
                "]",
                "{",
                "}",
                "(([])",
                "([]))"
        };

        for (String scenario : scenarios) {
            boolean isBalanced = Parentheses.isBalanced(scenario);
            Assertions.assertFalse(isBalanced);
        }
    }
}
