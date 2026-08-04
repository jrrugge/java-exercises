package com.amigoscode._2_developers._12_classes;

/**
 * Enum Exercises (Short for enumeration)
 *
 * Practice creating and using enums in Java. Enums are special classes that
 * represent a fixed set of constants. They can have fields, constructors,
 * and methods just like regular classes.
 */
public class EnumExercises {

    // TODO: 1 - Create an enum called Season with four constants:
    //  SPRING, SUMMER, AUTUMN, WINTER
    //  For now, just declare them without any fields or methods.
    enum Season {
        SPRING("Flowers Bloom"),
        SUMMER("Sun Shines"),
        AUTUMN("Leaves fall"),
        WINTER("Snow falls");

        //Private field to hold the custom data
        private final String description;

        //Enum constructor (implicitly private)
        Season(String description) {
            this.description = description;
        }

        //Getter method to retrieve the description
        public String getDescription() {
            return this.description;
        }
    }


    // TODO: 2 - Modify the Season enum to add:
    //  - A private final String 'description' field
    //  - A constructor that takes a String description and assigns it
    //  - Update each constant to pass a description, e.g.:
    //    SPRING("Flowers bloom"), SUMMER("Sun shines"),
    //    AUTUMN("Leaves fall"), WINTER("Snow falls")
    //  Note: Enum constructors are always private (even without the keyword).


    // TODO: 3 - Add a method getDescription() to the Season enum that
    //  returns the description field.


    // TODO: 4 - Create an enum called Priority with three constants:
    //  LOW(1), MEDIUM(2), HIGH(3)
    //  Each constant has a numeric level.
    //  Add:
    //  - A private final int 'level' field
    //  - A constructor that takes an int level
    //  - A getter getLevel()
//Enum priority with enum numeric levels
    enum Priority {
        Low(1),
        Medium(2),
        High(3);

        private final int level;
//constructor that takes an int level
        Priority(int level) {
            this.level = level;
        }
//Getter level
        public int getLevel() {
            return this.level;
        }
    }


    public static void main(String[] args) {
        System.out.println("=== Season Switch ===");
        // TODO: 5 - Use a switch statement (or switch expression) with a Season value.
        //  For each season, print a message like "Spring: Flowers bloom"
        //  using the getDescription() method.
        //  Test with Season.SUMMER.
        Season testSeason = Season.SUMMER;

        switch (testSeason) {
            case SPRING -> System.out.println("Spring: " + Season.SPRING.getDescription());
            case SUMMER -> System.out.println("Summer: " + Season.SUMMER.getDescription());
            case AUTUMN -> System.out.println("Autumn: " + Season.AUTUMN.getDescription());
            case WINTER -> System.out.println("Winter: " + Season.WINTER.getDescription());
        }

        System.out.println("\n=== Iterate Over Enum Values ===");
        // TODO: 6 - Use Season.values() to get an array of all Season constants.
        //  Loop through them and print each one with its description and ordinal.
        //  Example output: "0: SPRING - Flowers bloom"
        //  Also iterate over Priority.values() and print each with its level.
        //Loop through seasons
       //seasons.values() -> creates an array behind the scenes from the season values provided
       //Round 1 s is SPRING, s.ordinal is 0, s.getdescription() is Flowers bool" - enhanced for loops
        for(Season s: Season.values()) {
            System.out.println(s.ordinal() + ": " + s.name() + " - " + s.getDescription());
        }
        System.out.println(); //blank for line spacing

        //Priority values creates an array [Low medium high]
        //The loop assigns the current item to the temporary variable p
        //Instead of using ordinals this loop calls your custom getter method p.getlevel()
        for (Priority p : Priority.values()) {
            System.out.println(p.name() + " has a level of " + p.getLevel());
        }
    }
}
