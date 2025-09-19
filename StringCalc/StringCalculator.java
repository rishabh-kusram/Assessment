package StringCalc;

// Implementation of the String Calculator Kata
public class StringCalculator {
 public int add(String numbers) {
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

        // Parse each number and add to sum
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        return sum;
    }
}
