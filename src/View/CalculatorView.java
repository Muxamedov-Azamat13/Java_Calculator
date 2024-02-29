package View;

import Model.ComplexNumber;

import java.util.Scanner;

public class CalculatorView {


    public ComplexNumber getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите действительную часть: ");
        double realPart = scanner.nextDouble();
        System.out.print("Введите мнимую часть: ");
        double imaginaryPart = scanner.nextDouble();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public void displayResult(ComplexNumber result) {
        System.out.println("Результат: " + result);
    }

}
