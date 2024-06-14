//Calculating Sum of Elements using Stream API
import java.util.Arrays;

public class SumExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

     
        int sum = Arrays.stream(numbers)
              .sum();

        System.out.println("Sum of elements: " + sum);
    }
}