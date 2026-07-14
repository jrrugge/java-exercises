package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Conditional Statements
 *
 * Learn how to control the flow of your program using if/else and switch statements.
 * Conditional statements allow your program to make decisions based on conditions.
 */
public class ConditionalStatements {

    public static void main(String[] args) {

        // TODO: 1 - Write an if statement that prints "Positive" if a number is greater than 0
        // Declare an int variable called number and assign it a positive value.

        int number = 7;
        if (number > 0) {
            System.out.println("This number is positive");
    } else {
            System.out.println("The number is negative");
        }

        // TODO: 2 - Add an else clause to the above that prints "Not positive"
        // Change the value of number to a negative value or 0 to test both branches.


        // TODO: 3 - Write an if/else if/else chain for grade classification
        // Declare an int variable called score and assign it a value (0-100).
        // If score >= 90, print "Grade: A"
        // Else if score >= 80, print "Grade: B"
        // Else if score >= 70, print "Grade: C"
        // Else print "Grade: F"

        int score = 50;
        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 80) {
            System.out.println("Grade B");
        } else if (score >=70 ) {
            System.out.println("Grade C");
        } else
            System.out.println("Grade F");

        // TODO: 4 - Write a switch statement for day of the week
        // Declare an int variable called day (1-7).
        // Use a switch statement to print the day name:
        //   1 -> "Monday", 2 -> "Tuesday", ... 7 -> "Sunday"
        // Include a default case for invalid values.

        int day = 7;
        String dayName = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Invalid Day";
        };
        //You always output the variable that is being assigned the value
        System.out.println("The day you selected is "+ dayName);

        // TODO: 5 - Use a switch statement with a String
        // Declare a String variable called month (e.g., "February").
        // Use a switch statement to print the number of days in that month.
        // Handle at least 3-4 months plus a default case.

        String month = "May";
        switch (month) {
            case "January":
            case "May":
            case "March":
                System.out.println("Has 31 days");
                break;
            case "April":
                System.out.println("Has 30 days");
                break;
            case "February":
                System.out.println("Has 28 or 29 days");
                break;
            default:
                System.out.println("Unknown");
        }
        // TODO: 6 - Use a switch expression (Java 14+) to return a value
        // Using the 'day' variable from above, assign the day name to a String
        // using a switch expression with arrow syntax:
        //   String dayName = switch (day) {
        //       case 1 -> "Monday";
        //       ...
        //   };
        // Print the result.
        //already Done Above

        // TODO: 7 - Write a nested if statement to check if a number is positive AND even
        // Declare an int variable called value.
        // First check if it is positive (> 0).
        //   If positive, check if it is even (value % 2 == 0).
        //     If even, print "Positive and even"
        //     Else print "Positive and odd"
        //   Else print "Not positive"

        int value = -1;
        if (value > 0) {
            if (value % 2 == 0) {
                System.out.println("The Value is Positive and Even");
            } else {
                System.out.println("Positive and Odd");
            }

        } else System.out.println("Not Positive");

    }
}
