package StringCalc;

// Implementation of the String Calculator Kata
public class StringCalculator {
  public int add(String numbers) {
        // If the input string is empty or null, return 0
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        // Split the string using both comma and newline as delimiters
        // Regex: [,|\n] means "split on comma OR newline"
        String[] parts = numbers.split("[,\n]");

        int sum = 0;

        // Parse each number and add to sum
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        // Return the total
        return sum;
    }
}
