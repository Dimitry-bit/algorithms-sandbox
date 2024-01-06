package prj.algs4.chapter1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluatePostfixTest {

    @Test
    public void evaluatePostfix_evaluatePostfix_returnsPostfixResult() {
        String postfix = "2 3 + 4 * 5 / 2 -";

        double value = EvaluatePostfix.evaluatePostfix(postfix);
        double expected = (((2.0 + 3.0) * 4.0) / 5.0) - 2.0;

        Assertions.assertEquals(expected, value);
    }
}
