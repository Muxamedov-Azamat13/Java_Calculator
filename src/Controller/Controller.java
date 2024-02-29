package Controller;

import Model.ComplexNumber;
import View.CalculatorView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Controller {
    private CalculatorView view;

    private final Map<String, BiFunction<ComplexNumber, ComplexNumber, ComplexNumber>> operations;

    public Controller(CalculatorView view) {
        this.view = view;


        operations = new HashMap<>();
        operations.put("+", ComplexNumber::add);
        operations.put("*", ComplexNumber::multiply);
        operations.put("/", ComplexNumber::divide);
    }

    public void runCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите операцию: (+, *, /): ");
        String operation = scanner.next();

        if (!operations.containsKey(operation)) {
            System.out.println("Неверная операция.");
            return;
        }

        ComplexNumber num1 = view.getUserInput();
        ComplexNumber num2 = view.getUserInput();

        BiFunction<ComplexNumber, ComplexNumber, ComplexNumber> selectedOperation = operations.get(operation);
        ComplexNumber result = selectedOperation.apply(num1, num2);

        if (result != null) {
            view.displayResult(result);
        }
    }
}
