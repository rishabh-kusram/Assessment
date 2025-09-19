import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the StringCalculator class
public class StringCalculatorTest {

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
                () -> calc.add("1,-2,3"));
        assertEquals("negatives not allowed: -2", exception.getMessage());
    }

    // Case 6: Multiple negatives should all appear in the exception message
    @Test
    void add_MultipleNegatives_ThrowsExceptionWithAllNegatives() {
        StringCalculator calc = new StringCalculator();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calc.add("1,-2,3,-4"));
        assertEquals("negatives not allowed: -2, -4", exception.getMessage());
    }

    // Case 7: Track how many times add() was called
    @Test
    void getCalledCount_ReturnsNumberOfAddCalls() {
        StringCalculator calc = new StringCalculator();

        // At start, no calls yet
        assertEquals(0, calc.getCalledCount());

        // Call add() three times
        calc.add("1,2");
        calc.add("3");
        calc.add("");

        // Should return 3
        assertEquals(3, calc.getCalledCount());
    }

    // Case 8: Verify event is triggered after add() is called
    @Test
    void add_OccurredEventIsTriggered() {
        StringCalculator calc = new StringCalculator();

        // holder for event result
        final String[] capturedInput = new String[1];
        final int[] capturedResult = new int[1];

        // Subscribe a listener
        calc.addListener((input, result) -> {
            capturedInput[0] = input;
            capturedResult[0] = result;
        });

        // Call add()
        int result = calc.add("1,2");

        // Verify both the event and return value match
        assertEquals(3, result);
        assertEquals("1,2", capturedInput[0]);
        assertEquals(3, capturedResult[0]);
    }

    // Case 9: Numbers bigger than 1000 should be ignored
    @Test
    void add_NumbersGreaterThan1000_AreIgnored() {
        StringCalculator calc = new StringCalculator();
        assertEquals(2, calc.add("2,1001")); // 1001 ignored
        assertEquals(1002, calc.add("1000,2")); // 1000 included
    }

    // Case 10: Delimiters of any length
    @Test
    void add_CustomDelimiterOfAnyLength_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("//[***]\n1***2***3")); // delimiter = "***"
    }
}
