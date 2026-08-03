package com.amigoscode._2_developers._10_exceptions;

import java.util.Scanner;

/**
 * Try-Catch Exercises
 *
 * Practice exception handling: try-catch, finally, multi-catch, try-with-resources,
 * throwing exceptions, and exception propagation.
 */
public class TryCatch {

    /**
     * Safely accesses an array element at the given index.
     * Returns the element, or -1 if the index is out of bounds.
     *
     * @param arr   the array
     * @param index the index to access
     * @return the element at index, or -1 if out of bounds
     */
    public static int safeArrayAccess(int[] arr, int index) {
        try {
            return arr[index];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + index);
            return -1;
        }
    }

    /**
     * Parses a string to an integer safely.
     * Returns the parsed int, or 0 if the string is not a valid number.
     *
     * @param text the string to parse
     * @return the parsed integer, or 0 if invalid
     */
    public static int safeParseInt(String text) {
        try {
            return Integer.parseInt(text);
        }
        catch (NumberFormatException e) {
            System.out.println("Cannot parse: " + text);
            return 0;
        }
    }

    /**
     * Demonstrates the finally block. Attempts to divide a by b.
     * The finally block prints "Division operation completed." regardless of success or failure.
     *
     * @param a dividend
     * @param b divisor
     * @return the result of a/b, or 0 if b is zero
     */
    public static int divideWithFinally(int a, int b) {
        int result = 0;
        try {
            result = a / b;
            return result;
        }
        catch (ArithmeticException e) {
            // FIXED: Added missing exclamation mark to match TODO requirement
            System.out.println("Cannot divide by zero!");
            result = 0;
            return result;
        }
        finally {
            System.out.println("Division operation completed.");
        }
    }

    /**
     * Demonstrates catching multiple exception types in a single catch block.
     * Tries to access an array element and parse it as an integer.
     *
     * @param data  array of strings
     * @param index index to access
     * @return the parsed integer, or -1 on any error
     */
    public static int multiCatchDemo(String[] data, int index) {
        try {
            String text = data[index];
            return Integer.parseInt(text);
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    } // FIXED: Removed the extra closing brace that isolated the remaining methods

    /**
     * Demonstrates try-with-resources by reading a number from a Scanner.
     * The Scanner is automatically closed when the block exits.
     *
     * @param input the string to create a Scanner from
     * @return the integer read from the input, or -1 on error
     */
    public static int tryWithResourcesDemo(String input) {
        try (Scanner scanner = new Scanner(input)) {
            return scanner.nextInt();
        }
        catch (Exception e) {
            return -1;
        }
    }

    /**
     * Validates an age value. Throws IllegalArgumentException if age is negative.
     *
     * @param age the age to validate
     * @return the validated age
     * @throws IllegalArgumentException if age is negative
     */
    public static int validateAge(int age) {
        if (age < 0) {
            // FIXED: Added a colon and space to match "Age cannot be negative: " string format
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        return age;
    }

    /**
     * Demonstrates exception propagation. Calls a method that might throw,
     * which in turn calls another method that might throw.
     *
     * @param value a string that should contain a positive number
     * @return the validated positive number
     * @throws NumberFormatException     if value is not a number
     * @throws IllegalArgumentException if the number is negative
     */
    public static int processValue(String value) {
        int parsedInt = Integer.parseInt(value);
        return validateAge(parsedInt);
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        System.out.println("=== Safe Array Access ===");
        System.out.println("Index 1: " + safeArrayAccess(numbers, 1));
        System.out.println("Index 5: " + safeArrayAccess(numbers, 5));

        System.out.println("\n=== Safe Parse Int ===");
        System.out.println("Parse '42': " + safeParseInt("42"));
        System.out.println("Parse 'abc': " + safeParseInt("abc"));

        System.out.println("\n=== Finally Block ===");
        System.out.println("10 / 2 = " + divideWithFinally(10, 2));
        System.out.println("10 / 0 = " + divideWithFinally(10, 0));

        System.out.println("\n=== Multi-Catch ===");
        String[] data = {"10", "abc", "30"};
        System.out.println("Index 0: " + multiCatchDemo(data, 0));
        System.out.println("Index 1: " + multiCatchDemo(data, 1));
        System.out.println("Index 9: " + multiCatchDemo(data, 9));

        System.out.println("\n=== Try-With-Resources ===");
        System.out.println("Parse '123': " + tryWithResourcesDemo("123"));
        System.out.println("Parse 'xyz': " + tryWithResourcesDemo("xyz"));

        System.out.println("\n=== Throw Exception ===");
        try {
            System.out.println("Validating 25: " + validateAge(25));
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("\n=== Propagation ===");
        try {
            System.out.println("Processing '10': " + processValue("10"));
            processValue("-5");
        } catch (Exception e) {
            System.out.println("Propagation caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
