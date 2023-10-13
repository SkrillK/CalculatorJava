import java.util.Scanner;

public class Main {
    public static class Calculation {
        private static Scanner input = new Scanner(System.in);
        private static double number1, number2, result;
        private static String operation;
        boolean stop;

        Calculation() {
            this.number1 = 0;
            this.number2 = 0;
            this.operation = "";
            this.stop = false;
        }

        public void Run() {
            switch (this.operation) {
                case "+":
                    this.result = this.number1 + this.number2;
                    break;
                case "-":
                    this.result = this.number1 - this.number2;
                    break;
                case "*":
                    this.result = this.number1 * this.number2;
                    break;
                case "/":
                    this.result = this.number1 / this.number2;
                    break;
                case "s":
                    this.stop = true;
                    break;
                default:
                    System.out.println("Program can't read this operation...\n" +
                            "Try again or enter 's' to stop the program");
                    get_operation();
                    break;
            }
        }

        public void get_input() {
            System.out.printf("num1 = ");
            this.number1 = input.nextDouble();
            System.out.printf("num2 = ");
            this.number2 = input.nextDouble();
        }

        public void get_input(double last_result) {
            System.out.println("\nlast result = " + (this.number1 = last_result));
            System.out.printf("num2 = ");
            this.number2 = input.nextDouble();
        }

        public void get_operation() {
            System.out.printf("operation: ");
            this.operation = input.next();
            Run();
        }

        public double return_result() {
            return this.result;
        }
    }

    public static void main(String[] args) {
        Calculation calc = new Calculation();
        boolean next = false;
        double result = 0;

        while (true) {
            if (!next)
                calc.get_input();
            else
                calc.get_input(result);

            calc.get_operation();
            if(calc.stop)
                break;

            System.out.println("result = " + (result = calc.return_result()));
            next = true;
        }
    }
}