package StringCalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the StringCalculator class
class StringCalculatorTest {

    // Case 1: Empty string should return 0
    @Test
    void add_EmptyString_ReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add("")); // "" => 0
    }

    // Case 1: A single number should return that number
    @Test
    void add_SingleNumber_ReturnsThatNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(5, calc.add("5")); // "5" => 5
    }

    // Case 1: Two numbers should return their sum
    @Test
    void add_TwoNumbers_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2")); // "1,2" => 1+2 = 3
    }

    // Case 2: Handle an unknown amount of numbers
    @Test
    void add_MultipleNumbers_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(15, calc.add("1,2,3,4,5")); // "1,2,3,4,5" => 15
    }

     // Case 3: Support newline as a delimiter along with commas
    @Test
    void add_NumbersWithNewlines_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3")); // "1\n2,3" => 1+2+3 = 6
    }

    // Case 4: Support custom single-character delimiter
    @Test
    void add_CustomDelimiter_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2")); // delimiter = ";"
    }

      // Case 5: Negative numbers should throw an exception
    @Test
    void add_NegativeNumber_ThrowsException() {
        StringCalculator calc = new StringCalculator();
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calc.add("1,-2,3")
        );
        assertEquals("negatives not allowed: -2", exception.getMessage());
    }
}



