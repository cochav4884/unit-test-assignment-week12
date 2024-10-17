package com.promineotech;



public class TestDemo {

    // Removed inner class; methods can be part of TestDemo directly
    public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }

    public int addMultiply(int a, int b) {
        if (a > 0 && b > 0) {
            return (a + b) * a; // Change this as needed for your specific logic
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }
    
    // This method should return an integer; returning null is not appropriate.
    public int getRandomInt() {
        // Return a random integer for demonstration; you can modify as needed
        return (int) (Math.random() * 100); // Random integer between 0 and 99
    }

    // This method calculates the square of a random integer
    public int randomNumberSquared() {
        int randomInt = getRandomInt(); // Call getRandomInt to get a random integer
        return randomInt * randomInt; // Return the square of that integer
    }

    // The IntPredicate method is not necessary in this context
    // You might want to implement functionality based on it if needed.
}
