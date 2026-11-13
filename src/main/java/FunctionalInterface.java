import Models.Student;
import interfaces.MyFunction;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void customFunctionExample() {
        // Our interface declares R first, then T: Integer result, String input.
        // R apply(T input) becomes Integer apply(String input).
        MyFunction<Integer, String> getLength = text -> text.length();
        Integer length = getLength.apply("Hello");
        System.out.println("Length from lambda: " + length); // 5

        // A method reference provides the same implementation of apply().
        MyFunction<Integer, String> getLengthReference = String::length;
        System.out.println("Length from method reference: " + getLengthReference.apply("Hello")); // 5
    }

    public static void supplierExample() {
        // Supplier takes no input and returns a value through get().
        Supplier<Student> createStudent = () -> new Student("Zoe", 20);

        Student zoe = createStudent.get();
        System.out.println("Student from Supplier: " + zoe); // Zoe (20)
    }

    public static void consumerExample() {
        // Consumer takes one input and performs an action through accept(), returning no value.
        Consumer<Student> printStudent = student -> System.out.println(student);
        // Equivalent method reference: Consumer<Student> printStudent = System.out::println;

        Student zoe = new Student("Zoe", 20);
        printStudent.accept(zoe); // Prints: Zoe (20)
    }

    public static void functionExample() {
        // Function<T, R> takes a T type and returns an R type through apply().
        Function<Student, Integer> getAge = student -> student.getAge();
        // Equivalent method reference: Function<Student, Integer> getAge = Student::getAge;

        Student zoe = new Student("Zoe", 20);
        Integer age = getAge.apply(zoe);

        System.out.println("Age from Function: " + age); // 20
    }

    public static void predicateExample() {
        // Predicate takes one input and returns true or false through test().
        Predicate<Student> isAtLeast20 = student -> student.getAge() >= 20;

        Student zoe = new Student("Zoe", 20);
        Student bob = new Student("Bob", 19);

        System.out.println(zoe + " is at least 20: " + isAtLeast20.test(zoe)); // true
        System.out.println(bob + " is at least 20: " + isAtLeast20.test(bob)); // false
    }
}
