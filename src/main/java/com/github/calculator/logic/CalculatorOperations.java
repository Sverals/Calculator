package com.github.calculator.logic;

public class CalculatorOperations {

    public CalculatorOperations() {

    }

    public double add(double x, double y) {
        return x + y;
    }

    public double subtract(double x, double y) {
        return x - y;
    }

    public double squared(double x) {
        return x * x;
    }

    public double squareRoot(double x) {
        double result = Math.sqrt(x);
        if (Double.isNaN(result)) {
            throw new ArithmeticException("NaN");
        }
        return result;
    }

}
