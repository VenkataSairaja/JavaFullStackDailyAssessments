//HashMap Example 
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> studentMarks = new HashMap<>();
        studentMarks.put("John", 85);
        studentMarks.put("Alice", 92);
        studentMarks.put("Bob", 78);

        System.out.println("Student Names and Marks: ");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Marks: " + entry.getValue());
        }
    }
}