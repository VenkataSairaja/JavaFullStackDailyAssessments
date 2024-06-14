//Finding Maximum Element using Lambda Expressions
import java.util.Arrays;

public class MaximumElementExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};


        int maxElement = Arrays.stream(numbers)
               .max()
               .getAsInt();

        System.out.println("Maximum element: " + maxElement);
    }
}