package com.github.calculator.logic;

public class CalculatorFunctions {
    private StringBuilder userInput;
    private StringBuilder parenthesis;

    public CalculatorFunctions(String userInput) {
        this.userInput = new StringBuilder(userInput);

        this.parenthesis = new StringBuilder("");
        this.parseParenthesis();
    }

    public StringBuilder getUserInput() {
        return this.userInput;
    }

    public StringBuilder getParenthesis() {
        return parenthesis;
    }

    private void parseParenthesis() {
        for(int i = 0; i < this.userInput.length(); i++) {
            if(this.userInput.charAt(i) == '(') {
                int j = i;
                while(this.userInput.charAt(j) != ')') {
                    this.parenthesis.append(this.userInput.charAt(j));
                    j++;
                }
                this.parenthesis.append(')');
            }
        }
    }

    public void calcParenthesis() {
        StringBuilder num1 = new StringBuilder("");
        StringBuilder num2 = new StringBuilder("");
        for(int i = 0; i < this.parenthesis.length(); i++) {
            char currentChar = this.parenthesis.charAt(i);
            if(currentChar == 'x') {
                for(int j = 0; j < i;j++) {
                    if(this.parenthesis.charAt(j) != '(') {
                        num1.append(this.parenthesis.charAt(j));
                    }
                }
                System.out.println(num1);

                int k = i + 1;
                while(Character.isDigit(this.parenthesis.charAt(k))) {
                    num2.append(this.parenthesis.charAt(k));
                    k++;
                }
                System.out.println(num2);
            }
        }
    }
    private double additon(double num1, double num2) {
        return num1 + num2;
    }
}
