package Model;

import java.util.logging.Logger;

public class ComplexNumber {

    private static final Logger LOGGER = Logger.getLogger(ComplexNumber.class.getName());
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber add(ComplexNumber other) {
        LOGGER.info("Выполняеться операция сложения комплекснх чисел!");
        ComplexNumber result = new ComplexNumber(this.realPart + other.realPart,
                this.imaginaryPart + other.imaginaryPart);
        LOGGER.info("Результат: " + result);
        return result;
    }

    public ComplexNumber multiply(ComplexNumber other) {
        LOGGER.info("Выполняеться операция умножения комплекснх чисел!");
        double resultReal = this.realPart * other.realPart - this.imaginaryPart * other.imaginaryPart;
        double resultImaginary = this.realPart * other.imaginaryPart + this.imaginaryPart * other.realPart;
        LOGGER.info("Результат: " + resultReal + " + " + resultImaginary);
        return new ComplexNumber(resultReal, resultImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        LOGGER.info("Выполняется операция деления комплексных чисел!");

        double denominator = other.realPart * other.realPart + other.imaginaryPart * other.imaginaryPart;
        if (denominator == 0.0) {
            LOGGER.info("Деление на ноль недопустимо.");
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        double resultReal = (this.realPart * other.realPart + this.imaginaryPart * other.imaginaryPart) / denominator;
        double resultImaginary = (this.imaginaryPart * other.realPart - this.realPart * other.imaginaryPart) / denominator;

        LOGGER.info("Результат: " + resultReal + " + " + resultImaginary);

        return new ComplexNumber(resultReal, resultImaginary);
    }


    public boolean isZero() {
        return realPart == 0 && imaginaryPart == 0;
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }
}
