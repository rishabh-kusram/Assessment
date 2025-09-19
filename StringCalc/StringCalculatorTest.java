package StringCalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    // Case: empty string should return 0
    @Test
    public void testEmptyStringReturnsZero() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));
    }

    // Case: single number should return itself
    @Test
    public void testSingleNumberReturnsValue() {
        StringCalculator sc = new StringCalculator();
        assertEquals(5, sc.add("5"));
    }

    // Case: two numbers should return their sum
    @Test
    public void testTwoNumbersReturnsSum() {
        StringCalculator sc = new StringCalculator();
        assertEquals(8, sc.add("3,5"));
    }
}


