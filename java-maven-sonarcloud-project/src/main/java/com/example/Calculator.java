package com.example;

/**
 * Small calculator class used to demonstrate a Maven build and code analysis.
 */
public class Calculator {

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public double divide(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) first / second;
    }
}
