package com.github.calculator.logic;

import java.util.ArrayList;

public class CalculatorParser {
    private StringBuilder userInput;
    private StringBuilder parenthesis;
    private ArrayList<StringBuilder> pemdasPieces;

    public CalculatorParser(String userInput) {
        this.userInput = new StringBuilder(userInput);

        this.parenthesis = new StringBuilder("");
        this.parseParenthesis();

        this.pemdasPieces = new ArrayList<>();
    }

    public StringBuilder getUserInput() {
        return this.userInput;
    }

    public StringBuilder getParenthesis() {
        return parenthesis;
    }

    private void parseParenthesis() {
        boolean noParenthesis = true;
        int indexOfOpeningParenthesis = -1;
        int indexOfClosingParenthesis = -1;
        for(int i = 0; i < this.userInput.length(); i++) {
            if(this.userInput.charAt(i) == '(' && noParenthesis) {
                indexOfOpeningParenthesis = i;
                noParenthesis = false;
            }
            if(this.userInput.charAt(i) == ')') {
                indexOfClosingParenthesis = i;
            }
        }
        if(indexOfOpeningParenthesis > -1 && indexOfClosingParenthesis > -1) {
            this.parenthesis.append(this.userInput.toString()
                    .substring(indexOfOpeningParenthesis, indexOfClosingParenthesis));
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
