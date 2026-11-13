import Models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExamples {
    public static void comparatorLambdaExample() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Zoe", 20), new Student("Alice", 22), new Student("Bob", 19)));

        // Comparator has one abstract method, so a lambda can implement it.
        Comparator<Student> byAge = (first, second) -> Integer.compare(first.getAge(), second.getAge());
        students.sort(byAge);

        System.out.println("Sorted by age with a lambda: " + students);
    }
}
