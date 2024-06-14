//Finding Maximum Element using Stream API
import java.util.Arrays;
import java.util.Optional;

public class MaximumExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // Finding maximum element using Stream API
        Optional<Integer> maxElement = Arrays.stream(numbers)
              .boxed()
              .max((n1, n2) -> n1.compareTo(n2));

        if (maxElement.isPresent()) {
            System.out.println("Maximum element: " + maxElement.get());
        } else {
            System.out.println("No elements in the array.");
        }
    }
}