package com.github.calculator.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorOperationsTest {
    private CalculatorOperations calculatorOperations;

    @BeforeEach
    void setUp() {
        calculatorOperations = new CalculatorOperations();
    }
    //Addition test
    //second assert for transitive property
    @Test
    void additionAddsTwoPositiveNumbers() {
        assertEquals(5.0, calculatorOperations.add(2.0, 3.0));
        assertEquals(5.0, calculatorOperations.add(3.0, 2.0));
    }

    @Test
    void additionAddsNegativeWithPositive() {
        assertEquals(5.0, calculatorOperations.add(-2.0, 7.0));
        assertEquals(5.0, calculatorOperations.add(7.0, -2.0));
    }

    @Test
    void additionAddsNegativeWithNegative() {
        assertEquals(-5.0, calculatorOperations.add(-2.0, -3.0));
        assertEquals(-5.0, calculatorOperations.add(-3.0, -2.0));
    }

    @Test
    void additionReturnsADoubleWhenIntegerSupplied() {
        assertEquals(5.0, calculatorOperations.add(2, 3));
    }

    //subtraction test
    @Test
    void subtractionSubtractsTwoPositiveNumbers() {
        assertEquals(10.0, calculatorOperations.subtract(12.0, 2.0));
    }

    @Test
    void subtractionSubtractsNegativeWithPositive() {
        assertEquals(-10.0, calculatorOperations.subtract(-8.0, 2.0));
    }

    @Test
    void subtractionSubtractsNegativeWithNegative() {
        assertEquals(-5.0, calculatorOperations.subtract(-7.0, -2.0));
    }

    @Test
    void subtractionReturnsADoubleWhenIntegerSupplied() {
        assertEquals(1.0, calculatorOperations.subtract(2, 1));
    }




}