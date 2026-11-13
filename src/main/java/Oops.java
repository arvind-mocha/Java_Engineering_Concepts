import Models.Animal;
import Models.Cat;
import Models.Circle;
import Models.Counter;
import Models.Dog;
import interfaces.Drawable;
import interfaces.Shape;

public class Oops {

    public static void Inheritance(){
        Animal animal = new Animal();
        Dog dog = new Dog("Buddy", 2, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 3, true);

        animal.speak();
        dog.speak();
        cat.speak();
    }

    public static void casting() {
        // Upcasting: a Dog object can be stored in an Animal reference.
        Animal animal = new Dog("Buddy", 2, "Golden Retriever");
        animal.speak(); // Calls Dog's overridden method at runtime.

        // Downcasting: check the actual object type before using Dog-only methods.
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            System.out.println("Dog breed: " + dog.getBreed());
        }

        Animal cat = new Cat("Whiskers", 3, true);
        if (cat instanceof Dog) {
            Dog dog = (Dog) cat;
            System.out.println(dog.getBreed());
        } else {
            System.out.println("A Cat cannot be downcast to Dog.");
        }
    }

    public static void abstractionAndInterface() {
        Circle circle = new Circle(2);

        Shape shape = circle; // Abstract class reference.
        shape.printArea();

        Drawable drawable = circle; // Interface reference.
        drawable.draw();
    }

    public static void staticVsNonStatic() {
        Counter first = new Counter();
        Counter second = new Counter();

        first.increment();

        System.out.println("Static instances created: " + Counter.getInstancesCreated());
        System.out.println("First counter value: " + first.getValue());
        System.out.println("Second counter value: " + second.getValue());
    }
}
