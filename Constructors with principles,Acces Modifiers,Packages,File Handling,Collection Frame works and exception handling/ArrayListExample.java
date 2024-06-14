//Import the java.util.ArrayList class in your Java program and use it to store and retrieve elements.
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Elements in the list: ");
        for (String element : list) {
            System.out.println(element);
        }
    }
}