//Fibonacci Series
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of terms: ");
        int numTerms = scanner.nextInt();

        System.out.println("Fibonacci series up to " + numTerms + " terms: ");
        for (int i = 1; i <= numTerms; i++) {
            System.out.print(calculateFibonacci(i) + " ");
        }
    }

    public static int calculateFibonacci(int term) {
        if (term <= 1) {
            return term;
        } else {
            return calculateFibonacci(term - 1) + calculateFibonacci(term - 2);
        }
    }
}