package com.github.calculator.logic;

public class Main {
    public static void main(String[] args) {
        CalculatorParser calc = new CalculatorParser("(888x2222)2*2x11+2/2");
        calc.calcParenthesis();
    }
}
