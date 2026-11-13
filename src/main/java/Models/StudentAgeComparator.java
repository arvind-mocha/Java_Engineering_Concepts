package Models;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student first, Student second) {
        return Integer.compare(first.getAge(), second.getAge());
    }
}
