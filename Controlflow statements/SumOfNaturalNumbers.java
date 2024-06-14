//Sum Of Natural Numbers 
import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        int sum = calculateSum(num);

        System.out.println("The sum of first " + num + " natural numbers is: " + sum);
    }

    public static int calculateSum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}