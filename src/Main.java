public class Main {
    public static void main(String[] args) {
        ConsoleOutput out = new ConsoleOutput();
        Calculation calc = new Calculation();

        try {
            do {
                calc.result = out.clear_previous_result(calc.result);
                calc.input_phrase = out.get_input(calc.result);
                calc.Run();
                out.calc_result(calc.result);
            } while (!out.stop_calc());
        } catch (Exception e) {
            System.out.println("ERROR:\n\t" + e);
        }
    }
}