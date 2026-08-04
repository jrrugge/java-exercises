import java.util.Objects;

/**
 * Classes and Objects Exercises
 *
 * Practice creating classes with fields, constructors, and methods.
 * Learn about constructor chaining, toString(), and equals().
 */
public class ClassesAndObjects {

    // TODO: 1 - Create a static inner class called Person
    public static class Person {
        // Private fields to ensure data encapsulation
        private String name;
        private int age;

        // TODO: 2 - Add a constructor that takes String name and int age
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // TODO: 3 - Add a no-args constructor using constructor chaining
        public Person() {
            // Calls the two-argument constructor with default values
            this("Unknown", 0);
        }

        // TODO: 4 - Add a toString() method to format the object as text
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }

        // TODO: 5 - Add an equals() and hashCode() method for structural comparison
        @Override
        public boolean equals(Object obj) {
            // Check if both references point to the exact same object
            if (this == obj) {
                return true;
            }

            // Check if the other object is null or not a Person instance
            if (!(obj instanceof Person)) {
                return false;
            }

            // Cast the object to Person to compare individual fields
            Person other = (Person) obj;

            // Compare fields (Objects.equals handles potential null names safely)
            return this.age == other.age && Objects.equals(this.name, other.name);
        }

        @Override
        public int hashCode() {
            // Generate a unique hash code based on field values
            return Objects.hash(name, age);
        }
    }

    public static void main(String[] args) {
        // TODO: 6 - Create and test Person objects

        // Create an instance using the two-argument constructor
        Person person1 = new Person("Alice", 30);

        // Create an instance using the no-argument constructor
        Person person2 = new Person();

        // Create an instance identical to person1 to test structural equality
        Person person3 = new Person("Alice", 30);

        // Print the objects (implicitly invokes the overridden toString() method)
        System.out.println("Person 1: " + person1);
        System.out.println("Person 2: " + person2);
        System.out.println("Person 3: " + person3);
        System.out.println(); // Blank line for readability

        // Test the equals() method
        boolean match1And3 = person1.equals(person3);
        boolean match1And2 = person1.equals(person2);

        System.out.println("Is Person 1 equal to Person 3? (Expected: true) -> " + match1And3);
        System.out.println("Is Person 1 equal to Person 2? (Expected: false) -> " + match1And2);
        System.out.println(); // Blank line for readability

        // TODO: 7 - Demonstrate constructor chaining with this()
        /*
         * EXPLANATION OF CONSTRUCTOR CHAINING:
         * Constructor chaining occurs when one constructor calls another constructor
         * within the same class using the 'this(...)' keyword.
         * This approach prevents duplication of initialization logic, ensuring
         * that object setup happens in a single, central location.
         */
        System.out.println("No-args person: " + person2);
    }
}
