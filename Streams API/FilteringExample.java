//Filtering Strings using Stream API

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot");

  
        strings.stream()
              .filter(s -> s.startsWith("A"))
              .forEach(System.out::println);
    }
}