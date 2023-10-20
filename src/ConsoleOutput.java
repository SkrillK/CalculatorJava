public class ConsoleOutput {
    String answer;
    UserInput to_calc = new UserInput();
    boolean next = false;

    public boolean stop_calc() {
        System.out.println("Do you want to continue? y/n");
        answer = to_calc.input();

        if (!answer.equals("y"))
            return true;

        return false;
    }

    public String clear_previous_result(String result) {
        if (next) {
            System.out.println("Do you want to clear your previous result? y/n");
            answer = to_calc.input();

            if (answer.equals("y")) {
                next = false;
                return result = "0.0";
            }
        }
        return result;
    }

    public String get_input(String last_result) {
        String phrase = "";

        if (next) {
            System.out.println("\nContinue your math phrase. (without space)");
            System.out.printf(last_result);
            phrase = last_result + to_calc.input();
        }
        else {
            System.out.println("\nInput your math phrase. (without space)");
            phrase = to_calc.input();
        }
        next = true;

        return phrase;
    }

    public void calc_result(String result){
        System.out.println("Result: " + result);
    }
}
