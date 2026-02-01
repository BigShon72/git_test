import java.util.Scanner;

public class ProductRecursionTwo {

        public static int recursiveProduct(int[] numbers, int position) {
        if (position == numbers.length) {
            return 1; // Multiplicative identity
        }
        return numbers[position] * recursiveProduct(numbers, position + 1);
    }

        public static int[] getUserNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[5];

        System.out.println("Please enter 5 integers:");

        for (int i = 0; i < values.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        return values;
    }

        public static void displayResult(int product) {
        System.out.println("The product of the 5 numbers is: " + product);
    }

    public static void main(String[] args) {
        int[] userNumbers = getUserNumbers();
        int result = recursiveProduct(userNumbers, 0);
        displayResult(result);
    }
}