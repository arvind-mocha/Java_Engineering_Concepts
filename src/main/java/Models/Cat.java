package Models;

public class Cat extends Animal {
    private String name;
    private int age;
    private boolean indoor;

    public Cat() {
        this("Whiskers", 3, true);
    }

    public Cat(String name, int age, boolean indoor) {
        this.name = name;
        this.age = age;
        this.indoor = indoor;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isIndoor() {
        return indoor;
    }

    @Override
    public void speak() {
        System.out.println("The cat meows.");
    }
}
