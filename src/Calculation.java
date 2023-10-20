public class Calculation {
    private double[] numbers = new double[10];
    private char[] operations = new char[9];
    private String main_phrase;
    String input_phrase;
    String result;

    public void Run() {
        main_phrase = input_phrase;

        calc_brackets();
        result = calculate(main_phrase);
    }

    private void calc_brackets() {
        String buff_phrase = "";
        boolean no_right_bracket = false, calculated = false;

        for (int i = 0; i < main_phrase.length(); i++) {
            if (main_phrase.toCharArray()[i] == '(' && !no_right_bracket) {
                no_right_bracket = true;
                for (int j = i + 1; j < main_phrase.length(); j++) {
                    if(main_phrase.toCharArray()[j] == ')') {
                        no_right_bracket = false;
                        break;
                    }
                    buff_phrase += main_phrase.toCharArray()[j];
                    if(main_phrase.toCharArray()[j] == '(')
                        buff_phrase = "";
                }
                calculated = true;
            }

            if (no_right_bracket) {
                System.out.println("No right bracket");
                return;
            }
            else if (calculated){
                main_phrase = main_phrase.replace("(" + buff_phrase + ")", calculate(buff_phrase));

                i = 0;
                buff_phrase = "";
                calculated = false;
            }
        }
    }

    private String calculate(String phrase) {
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
            if (operations[index] == '*' || operations[index] == '/') {
                if (operations[index] == '*')
                    numbers[i] *= numbers[i + 1];
                else
                    numbers[i] /= numbers[i + 1];

                for (int j = i + 1; j <= n; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j - 1] = operations[j];
                }
                i--;
            }
            else
                index++;
        }
        index = 0;

        for (int i = 0; i < n; i++) {
            if (operations[index] == '+' || operations[index] == '-') {
                if (operations[index] == '+')
                    numbers[i] += numbers[i + 1];
                else
                    numbers[i] -= numbers[i + 1];

                for (int j = i + 1; j <= n; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j - 1] = operations[j];
                }
                i--;
            }
            else
                index++;
        }

        return Double.toString(numbers[0]);
    }
}