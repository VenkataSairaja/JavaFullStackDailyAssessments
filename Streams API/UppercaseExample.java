//Converting Strings to Uppercase using Stream API
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world", "java", "programming");

        // Converting strings to uppercase using Stream API
        List<String> uppercaseStrings = strings.stream()
              .map(String::toUpperCase)
              .collect(Collectors.toList());

        System.out.println("Uppercase strings: " + uppercaseStrings);
    }
}