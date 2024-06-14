//Check Even Or Odd
import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        if (isEven(num)) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}