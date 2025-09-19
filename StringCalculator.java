
import java.util.ArrayList;
import java.util.List;

// Implementation of the String Calculator Kata
public class StringCalculator {

    // Case 7: Keep track of how many times add() was called
    private int callCount = 0;

    // Case 8: Maintain a list of listeners (subscribers to the event)
    private final List<AddListener> listeners = new ArrayList<>();

    public int add(String numbers) {
        // Increment call count every time add() is called
        callCount++;

        // If the input string is empty or null, return 0
        if (numbers == null || numbers.isEmpty()) {
            triggerAddOccurred(numbers, 0);
            return 0;
        }

        String delimiter = "[,\n]"; // Default delimiters: comma or newline
        String numberString = numbers;

        // Case 4 & Case 10: Check for custom delimiter format
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, delimiterEndIndex);

            // Case 10: If delimiter is wrapped in [ ], it may have any length
            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                // Strip off [ ] and escape regex meta chars
                delimiter = java.util.regex.Pattern.quote(
                        delimiterPart.substring(1, delimiterPart.length() - 1));
            } else {
                // Case 4: Single-character delimiter
                delimiter = java.util.regex.Pattern.quote(delimiterPart);
            }

            numberString = numbers.substring(delimiterEndIndex + 1);
        }

        // Split by chosen delimiter(s)
        String[] parts = numberString.split(delimiter);

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int value = Integer.parseInt(part);

            // Case 5 & 6: Collect negative numbers
            if (value < 0) {
                negatives.add(value);
            }

            // Case 9: Ignore numbers greater than 1000
            if (value <= 1000) {
                sum += value;
            }
        }

        // Case 5 & 6: Throw exception if negatives exist
        if (!negatives.isEmpty()) {
            String message = "negatives not allowed: " +
                    negatives.toString().replaceAll("[\\[\\]]", "");
            throw new IllegalArgumentException(message);
        }

        // Case 8: Trigger event for successful Add()
        triggerAddOccurred(numbers, sum);

        return sum;
    }

    /**
     * Case 7: Returns how many times add() was invoked.
     */
    public int getCalledCount() {
        return callCount;
    }

    /**
     * Case 8: Allow external code to subscribe to AddOccurred events.
     */
    public void addListener(AddListener listener) {
        listeners.add(listener);
    }

    // Notify all registered listeners
    private void triggerAddOccurred(String input, int result) {
        for (AddListener listener : listeners) {
            listener.onAdd(input, result);
        }
    }
}
