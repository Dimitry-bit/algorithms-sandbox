package prj.algs4.chapter2.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CertificationTest {
    @Test
    public void certification_arraySort_shouldReturnTrue() {
        Integer[] src = { -1, 0, -5, 2 };
        Assertions.assertTrue(Certification.check(src));
    }
}
