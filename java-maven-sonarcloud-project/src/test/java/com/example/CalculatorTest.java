package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addsTwoNumbers() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    void subtractsTwoNumbers() {
        assertEquals(6, calculator.subtract(10, 4));
    }

    @Test
    void multipliesTwoNumbers() {
        assertEquals(20, calculator.multiply(5, 4));
    }

    @Test
    void dividesTwoNumbers() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
    }

    @Test
    void divisionByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }
}
