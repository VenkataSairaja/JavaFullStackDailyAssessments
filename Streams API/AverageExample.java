import java.util.Scanner;
import java.util.stream.IntStream;

//Calculating Average of Integers using Stream API
public class AverageExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of integers: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the integers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Calculating average using Stream API
        double average = IntStream.of(numbers)
              .average()
              .getAsDouble();

        System.out.println("Average of integers: " + average);
    }
}