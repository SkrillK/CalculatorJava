import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Calculation {
        private static Scanner input = new Scanner(System.in);
        private static double result;
        private static double[] numbers = new double[10] ;
        private static char[] operations = new char[9];
        private static String phrase, answer;
        boolean stop = false;

        public void Run() {
            int n = 0, index = 0;
            String buff = "";
            for (int i = 0; i < phrase.length(); i++) {
                if (Character.isDigit(phrase.toCharArray()[i]) || phrase.toCharArray()[i] == ','
                        || phrase.toCharArray()[i] == '.')
                    buff += phrase.toCharArray()[i];
                else {
                    operations[n] = phrase.toCharArray()[i];
                    numbers[n] = Double.parseDouble(buff.replace(",", "."));
                    buff = "";
                    n++;
                }
            }
            numbers[n] = Double.parseDouble(buff.replace(",", "."));

            for (int i = 0; i < n; i++) {
                if (operations[index] == '*') {
                    numbers[i] *= numbers[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        numbers[j] = numbers[j + 1];
                        operations[j - 1] = operations[j];
                    }
                }
                index++;
            }
            index = 0;

            for (int i = 0; i < n; i++) {
                if (operations[index] == '/') {
                    numbers[i] /= numbers[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        numbers[j] = numbers[j + 1];
                        operations[j - 1] = operations[j];
                    }
                }
                index++;
            }
            index = 0;

            for (int i = 0; i < n; i++) {
                if (operations[index] == '+') {
                    numbers[i] += numbers[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        numbers[j] = numbers[j + 1];
                        operations[j - 1] = operations[j];
                    }
                }
                index++;
            }
            index = 0;

            for(int i = 0; i < n; i++) {
                if (operations[index] == '-') {
                    numbers[i] -= numbers[i + 1];
                    for (int j = i + 1; j <= n; j++) {
                        numbers[j] = numbers[j + 1];
                        operations[j - 1] = operations[j];
                    }
                }
                index++;
            }

            System.out.println("result = " + (result = numbers[0]));

            System.out.println("Do you want to continue? y/n");
            answer = input.next();
            if(answer.equals("y"))
                stop = false;
            else
                stop = true;
        }

        public void get_input() {
            System.out.println("Input your math phrase. (without space)");
            phrase = input.next();
        }

        public void get_input(String last_result)
        {
            System.out.println("\nContinue your math phrase.");
            System.out.printf(last_result);
            phrase = last_result + input.next();
        }

        public double return_result() {
            return result;
        }
    }

    public static void main(String[] args) {
        Calculation calc = new Calculation();
        boolean next = false;
        double result = 0;

        while (!calc.stop) {
            if (next)
                calc.get_input(Double.toString(result));
            else
                calc.get_input();
            calc.Run();

            result = calc.return_result();
            next = true;
        }
    }
}