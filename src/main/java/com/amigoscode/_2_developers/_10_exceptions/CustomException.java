package com.amigoscode._2_developers._10_exceptions;

/**
 * Custom Exception Exercises
 *
 * Practice creating custom checked and unchecked exceptions, throwing them
 * from methods, catching them, and using exception chaining.
 */
public class CustomException {

    // TODO: 1 - Create a custom CHECKED exception class called InsufficientFundsException.
    //  It should:
    //  - Extend Exception (making it a checked exception)
    //  - Have a private final double 'amount' field (the amount that was short)
    //  - Have a constructor that takes a String message and double amount,
    //    calls super(message), and stores the amount
    //  - Have a getter: double getAmount()
    //  Define it as a static inner class here, or as a separate class in this package.
   // custom checked exception class
    public static class InsufficientFundsException extends Exception {
        //Field to store how much money the user was short of
        private final double amount;

        //Constructor to set the error message and the shortage amount
        public InsufficientFundsException(String message, double amount) {
            //Super(message) passes the text to the parent Exception class so getMessage() works
            super(message);
            this.amount  = amount;
        }

        //Getter method so we can read the short amount when we catch the error
        public double getAmount() {
            return amount;
        }
    }

    // TODO: 2 - Create a custom UNCHECKED exception class called InvalidAgeException.
    //  It should:
    //  - Extend RuntimeException (making it an unchecked exception)
    //  - Have a constructor that takes a String message and calls super(message)
    //  - Have a constructor that takes a String message and a Throwable cause,
    //    and calls super(message, cause)
    //  Define it as a static inner class here.

    public static class InvalidAgeException extends RuntimeException {

        //Constructor 1: Takes just a simple error message
        public InvalidAgeException(String message) {
            super(message);
        }

        //Constructor 2: Takes a message AND another exception, i.e. the cause for exception chaining
        public  InvalidAgeException(String message, Throwable cause) {
            super(message, cause);
        }
    }


    // TODO: 3 - Create a static inner class BankAccount with:
    //  - A private double 'balance' field
    //  - A constructor that takes an initial balance
    //  - A method: void withdraw(double amount) throws InsufficientFundsException
    //    If amount > balance, throw new InsufficientFundsException with an appropriate
    //    message and the shortfall amount (amount - balance).
    //    Otherwise, subtract amount from balance.
    //  - A method: double getBalance()
    public static class BankAccount {
        private double balance;

        //Constructor to setup the starting money
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        //This method warns java that it might throw a checked exception using the 'throw' keywords
        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount > balance) {
                //calculate how much money is missing
                double shortfall = amount - balance;
                //Use 'throw' to trigger the error and stop the method exception
                throw new InsufficientFundsException("Error: You do not have enough money!", shortfall);
            } else {
                //Deduct money if there is enough balance
                balance -= amount;
            }
        }
        public double getBalance() {
            return balance;
        }
    }

    // TODO: 4 - Create a static method: void validateAge(int age)
    //  If age < 0 or age > 150, throw a new InvalidAgeException with an appropriate message.
    //  Otherwise, print "Age " + age + " is valid."

    public static void validdateAge(int age) {
        //check if the age falls outside humanly possible limits
        if(age < 0 || age > 150) {
            //Throw our unchecked exception (no 'throws' needed in method signature)
            throw new InvalidAgeException("Age must be between 0 and 150: " + age);
        }
        System.out.println("Age" + age + "is valid");
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Checked Exception (InsufficientFundsException) ===");
        // TODO: 5 - Create a BankAccount with balance 100.
        //  Try to withdraw 50 (should succeed, print remaining balance).
        //  Try to withdraw 75 (should throw InsufficientFundsException).
        //  Catch the exception and print its message and the shortage amount.
        //  Also try validateAge with valid (25) and invalid (-5) values,
        //  catching InvalidAgeException.

        BankAccount account = new BankAccount(100.0);

        try {
            //First withdrawal of 50
            System.out.println("Attempting to withdraw 50");
            account.withdraw(50);
            System.out.println("Withdrawal successful! Remaining Balance: " + account.getBalance());

            //Second withdrawal of 75. insufficient funds hence will jump to the catch block
            System.out.println("Attempting to withdraw 75...");
            account.withdraw(75);
            System.out.println("This line will not print because an exception happened above");

        } catch (InsufficientFundsException e) {
            //Handle the checked exception here
            System.out.println("Caught Exception: " + e.getMessage());
            System.out.println("Shortage Amount: $" + e.getMessage());
        }
        //Testing age validation with try-catch blocks
        try {
            System.out.println("\nTesting validateAge with 25:");
            validdateAge(25);

            System.out.println("Testing validateAge with -5");
            validdateAge(-5);
        } catch (InvalidAgeException e) {
            //Handle the unchecked exception here
            System.out.println("Caught Exception: " + e.getMessage());
        }


        System.out.println("\n=== Exception Chaining ===");
        // TODO: 6 - Demonstrate exception chaining:
        //  In a try block, parse an invalid string like "abc" with Integer.parseInt().
        //  In the catch block for NumberFormatException, create a new InvalidAgeException
        //  with the original exception as the cause (using the two-arg constructor
        //  or initCause()). Throw the new exception.
        //  In an outer try-catch, catch the InvalidAgeException and print:
        //  - The exception message
        //  - The cause (using getCause())

        try {
            //outer try block catches the wrapped customer exception
            try {
                //Inner try block tries to turn text into a numner
                String InvalidAgeText = "abc";
                //This line will crash and throw a Number format exception
                int parsedAge = Integer.parseInt(InvalidAgeText);
            } catch (NumberFormatException originalError) {
                System.out.println("Inner catch: Caught Numberformatexception. Wrapping it now...");
                //Wrap the standard java error into our custom InvalidAgeException
                throw new InvalidAgeException("Failed to parse the age string.", originalError);
            }
        } catch (InvalidAgeException wrappedError) {
            //Print readable customer error message
            System.out.println("Our Catch: " + wrappedError.getMessage());
            //Retrieve and print the hidden root cause exception using getMessage()
            System.out.println("Root cause: " + wrappedError.getCause());
        }

    }
}
