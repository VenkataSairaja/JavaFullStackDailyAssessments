//Mapping Integers to Squares using Stream API
import java.util.Arrays;
import java.util.List;

public class 
{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Mapping integers to squares using Stream API
        numbers.stream()
              .map(n -> n * n)
              .forEach(System.out::println);
    }
}