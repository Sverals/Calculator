package com.github.calculator.logic;

public class Main {
    public static void main(String[] args) {
        CalculatorFunctions calc = new CalculatorFunctions("(888x2222)2*2x11+2/2");
        calc.calcParenthesis();
    }
}
