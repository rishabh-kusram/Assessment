package StringCalc;

public class StringCalculator {

    // Add method: takes numbers as a string and returns their sum
    public int add(String numbers) {
        // Case: empty string -> return 0
        if (numbers.isEmpty()) {
            return 0;
        }

        // Split by comma
        String[] parts = numbers.split(",");

        // Case: only one number -> return it
        if (parts.length == 1) {
            return Integer.parseInt(parts[0]);
        }

        // Case: exactly two numbers -> return sum
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        return num1 + num2;
    }
}

