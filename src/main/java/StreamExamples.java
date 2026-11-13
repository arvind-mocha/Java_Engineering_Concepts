import Models.Student;

import java.util.Comparator;
import java.util.List;

public class StreamExamples {
    public static void streamExamples() {
        List<Student> students = List.of(
                new Student("Zoe", 20), new Student("Alice", 22),
                new Student("Bob", 19), new Student("Mia", 20));

        // A stream processes elements from a source collection.
        // Intermediate operations (filter, map, sorted) build a pipeline.
        // A terminal operation (forEach, toList, count) runs the pipeline.
        // Create a fresh stream for each example: a stream can only be used once.

        // 1. filter uses a Predicate; forEach uses a Consumer.
        System.out.println("Students aged at least 20:");
        students.stream()
                .filter(student -> student.getAge() >= 20)
                .forEach(System.out::println);

        // 2. map uses a Function to turn each Student into an Integer.
        List<Integer> ages = students.stream()
                .map(Student::getAge)
                .toList();
        System.out.println("Ages: " + ages); // [20, 22, 19, 20]

        // 3. distinct removes duplicate ages; sorted orders them.
        List<Integer> uniqueAges = students.stream()
                .map(Student::getAge)
                .distinct()
                .sorted()
                .toList();
        System.out.println("Unique ages in order: " + uniqueAges); // [19, 20, 22]

        // 4. Sort by age, then keep only the two youngest students.
        List<Student> youngest = students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .limit(2)
                .toList();
        System.out.println("Two youngest: " + youngest); // [Bob (19), Zoe (20)]

        // 5. count returns the number of elements that pass the filter.
        long count = students.stream()
                .filter(student -> student.getAge() >= 20)
                .count();
        System.out.println("Number aged at least 20: " + count); // 3

        // 6. anyMatch stops as soon as it finds a matching student.
        boolean hasTeenager = students.stream()
                .anyMatch(student -> student.getAge() < 20);
        System.out.println("Has a teenager: " + hasTeenager); // true

        // 7. findFirst returns an Optional because there might be no match.
        students.stream()
                .filter(student -> student.getAge() >= 21)
                .findFirst()
                .ifPresent(student -> System.out.println("First aged at least 21: " + student));

        // 8. reduce combines ages into one value, starting with 0.
        int totalAge = students.stream()
                .map(Student::getAge)
                .reduce(0, Integer::sum);
        System.out.println("Total age: " + totalAge); // 81

        // These pipelines leave the original list in its original order.
        System.out.println("Original students: " + students);
    }
}
