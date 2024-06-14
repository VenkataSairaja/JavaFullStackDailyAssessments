//Factorial Using Method 
import java.util.Scanner;

public class FactorialUsingMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        long factorial = calculateFactorial(num);

        System.out.println("The factorial of " + num + " is: " + factorial);
    }

    public static long calculateFactorial(int num) {
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
}