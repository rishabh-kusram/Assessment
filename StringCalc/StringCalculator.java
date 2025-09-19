package StringCalc;

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
            return 0;
        }

        String delimiter = "[,\n]"; // Default delimiters: comma or newline
        String numberString = numbers;

        // Case 4: Check for custom delimiter format: //{delimiter}\n{numbers}
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEndIndex); // extract delimiter
            numberString = numbers.substring(delimiterEndIndex + 1); // extract numbers
        }

        // Split by chosen delimiter(s)
        String[] parts = numberString.split(delimiter);

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int value = Integer.parseInt(part);

            // Collect negative numbers
            if (value < 0) {
                negatives.add(value);
            }

            sum += value;
        }

        // Case 5 & 6: If negatives were found, throw exception
        if (!negatives.isEmpty()) {
            String message = "negatives not allowed: " +
                    negatives.toString().replaceAll("[\\[\\]]", "");
            throw new IllegalArgumentException(message);
        }

        return sum;
    }

    /**
     * Case 7: Returns how many times add() was invoked.
     * 
     * @return number of times add() has been called
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
