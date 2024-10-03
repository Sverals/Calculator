package com.github.calculator.data;

public enum Operators {
    PLUS('='),
    MINUS('-'),
    MULTIPLY('x'),
    DIVIDE('÷'),
    POWER('²'),
    LEFTPARENTHESIS('('),
    RIGHTPARENTHESIS(')');

    private final char type;

    Operators(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }
}
