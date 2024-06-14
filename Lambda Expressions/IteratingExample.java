//Iterating through a List of Strings using Lambda Expressions
import java.util.Arrays;
import java.util.List;

public class IteratingExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world", "java", "programming");

   
        strings.stream()
               .map(String::toUpperCase)
               .forEach(System.out::println);
    }
}