//Array List Example 
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(10); // integer
        list.add("Hello"); // string
        list.add(3.14); // double
        list.add(true); // boolean

        System.out.println("Elements in the list: ");
        for (Object element : list) {
            System.out.println(element);
        }
    }
}