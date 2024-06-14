// Sorting an Array of Strings using Lambda Expressions
import java.util.Arrays;

public class SortingExample {
    public static void main(String[] args) {
        String[] strings = {"hello", "world", "abc", "xyz", "java"};

        // Sorting in descending order using lambda expression
        Arrays.sort(strings, (s1, s2) -> s2.compareTo(s1));

        System.out.println("Sorted array in descending order: ");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}