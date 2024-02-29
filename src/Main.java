import Controller.Controller;
import View.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        Controller controller = new Controller(view);
        controller.runCalculator();
    }
}
