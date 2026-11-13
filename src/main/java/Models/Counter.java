package Models;

public class Counter {
    private static int instancesCreated = 0; // Shared by every Counter object.
    private int value = 0; // Each Counter object has its own value.

    public Counter() {
        instancesCreated++;
    }

    public static int getInstancesCreated() {
        return instancesCreated;
    }

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
