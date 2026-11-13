public class Main {
    public static void main(String[] args) {
        // Object-oriented programming concepts
        System.out.println("\n=== Inheritance ===");
        Oops.Inheritance();

        System.out.println("\n=== Casting ===");
        Oops.casting();

        System.out.println("\n=== Abstraction and Interface ===");
        Oops.abstractionAndInterface();

        System.out.println("\n=== Static vs Non-Static ===");
        Oops.staticVsNonStatic();

        // Collections framework examples
        System.out.println("\n=== List ===");
        CollectionFramework.listExample();

        System.out.println("\n=== Set ===");
        CollectionFramework.setExample();

        System.out.println("\n=== Map ===");
        CollectionFramework.mapExample();

        System.out.println("\n=== HashMap ===");
        CollectionFramework.hashMapExample();

        System.out.println("\n=== Queue ===");
        CollectionFramework.queueExample();

        System.out.println("\n=== Comparable ===");
        CollectionFramework.comparableExample();

        System.out.println("\n=== Comparator ===");
        CollectionFramework.comparatorExample();

        System.out.println("\n=== Lambda Comparator ===");
        LambdaExamples.comparatorLambdaExample();

        System.out.println("\n=== Predicate ===");
        FunctionalInterface.predicateExample();

        System.out.println("\n=== Function ===");
        FunctionalInterface.functionExample();

        System.out.println("\n=== Consumer ===");
        FunctionalInterface.consumerExample();

        System.out.println("\n=== Supplier ===");
        FunctionalInterface.supplierExample();

        System.out.println("\n=== Streams ===");
        StreamExamples.streamExamples();
    }
}
