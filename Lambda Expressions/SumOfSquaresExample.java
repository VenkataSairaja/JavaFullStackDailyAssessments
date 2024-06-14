//Calculating Sum of Squares using Lambda Expressions
import java.util.Arrays;

public class SumOfSquaresExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        
        int sumOfSquares = Arrays.stream(numbers)
               .map(n -> n * n)
               .sum();

        System.out.println("Sum of squares: " + sumOfSquares);
    }
}