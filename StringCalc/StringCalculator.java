package StringCalc;

// Implementation of the String Calculator Kata (Cases 1 + 2)
public class StringCalculator {
    public int add(String numbers) {
        // If the input string is empty or null, return 0
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        // Split the string into parts using comma as a delimiter
        String[] parts = numbers.split(",");

        int sum = 0;

        // Parse each number from string to int and add it to the sum
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        // Return the final computed sum
        return sum;
    }
}
