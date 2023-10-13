import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1 = 0, num2 = 0, result = 0;
        String operation = " ";
        boolean continue_calculating = false, stop = false;

        while(!stop)
        {
            if (continue_calculating)
            {
                num1 = result;
                System.out.println("\nnum1 = " + num1);
            }
            else
            {
                System.out.printf("num1 = ");
                num1 = input.nextDouble();
                continue_calculating = true;
            }

            System.out.printf("num2 = ");
            num2 = input.nextDouble();

            System.out.printf("operation: ");
            operation = input.next();
            switch (operation)
            {
                case "+":
                    System.out.println("num1 + num2 = " + (result = num1 + num2));
                    break;
                case "-":
                    System.out.println("num1 - num2 = " + (result = num1 - num2));
                    break;
                case "*":
                    System.out.println("num1 * num2 = " + (result = num1 * num2));
                    break;
                case "/":
                    System.out.println("num1 / num2 = " + (result = num1 / num2));
                    break;
                default:
                    stop = true;
                    break;
            }
        }
    }
}