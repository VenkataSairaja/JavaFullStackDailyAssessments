//InputMismatch Exception Example 
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter an integer: ");
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter an integer.");
        } finally {
            scanner.close();
            System.out.println("Finally block executed.");
        }
    }
}