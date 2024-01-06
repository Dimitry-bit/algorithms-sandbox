package prj.algs4.chapter1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InfixToPostfixTest {

    @Test
    public void infixToPostFix_toPostFix_returnsPostfixExpression() {
        String infix = "( 2 + 3 ) * 4 / 5 - 2";

        String value = InfixToPostfix.toPostfix(infix);
        String expected = "2 3 + 4 * 5 / 2 -";

        Assertions.assertEquals(expected, value);
    }
}
