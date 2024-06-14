//Filtering Even Numbers using Lambda Expressions
import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        // Filtering even numbers using lambda expression
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(n -> System.out.println("Even number: " + n));
    }
}