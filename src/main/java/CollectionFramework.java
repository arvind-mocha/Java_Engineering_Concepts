import Models.Student;
import Models.StudentAgeComparator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CollectionFramework {
    public static void listExample() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // Lists allow duplicates and preserve order.

        System.out.println("List: " + fruits);
        System.out.println("First fruit: " + fruits.get(0));
    }

    public static void setExample() {
        Set<String> fruits = new LinkedHashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // Sets ignore duplicates.

        System.out.println("Set: " + fruits);
    }

    public static void mapExample() {
        Map<String, Integer> ages = new LinkedHashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Alice", 26); // A repeated key replaces its value.

        System.out.println("Map: " + ages);
        System.out.println("Alice's age: " + ages.get("Alice"));
    }

    public static void hashMapExample() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Alice", 95); // The same key updates the existing value.

        System.out.println("Alice's score: " + scores.get("Alice"));
        System.out.println("Contains Bob: " + scores.containsKey("Bob"));
        scores.remove("Bob");
        System.out.println("Size after removing Bob: " + scores.size());
        // HashMap does not guarantee iteration order.
    }

    public static void queueExample() {
        Queue<String> tasks = new ArrayDeque<>();
        tasks.add("First task");
        tasks.add("Second task");

        System.out.println("Next task: " + tasks.peek());
        System.out.println("Completed: " + tasks.remove());
        System.out.println("Remaining queue: " + tasks);
    }

    public static void comparableExample() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Zoe", 20), new Student("Alice", 22), new Student("Bob", 19)));
        Collections.sort(students); // Uses Student.compareTo() to sort by name.
        System.out.println("Natural order (name): " + students);
    }

    public static void comparatorExample() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Zoe", 20), new Student("Alice", 22), new Student("Bob", 19)));
        students.sort(new StudentAgeComparator()); // Uses a separate rule to sort by age.
        System.out.println("Custom order (age): " + students);
    }
}
