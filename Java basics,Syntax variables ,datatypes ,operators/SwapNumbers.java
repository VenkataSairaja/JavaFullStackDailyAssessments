//SwapNumbers 
public class SwapNumbers {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        System.out.println("Before swapping: ");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        swapNumbers(num1, num2);

        System.out.println("After swapping: ");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swapNumbers(int num1, int num2) {
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
    }
}