import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafety {
    public static void threadSafetyExample() throws InterruptedException {
        // One shared service instance, like Spring's default singleton service.
        PricingService service = new PricingService();

        //private int price = 100 // if we pass this into the calculateTotal as parameter it may not be threadsafe anymore, because it is being shared ny different threads

        Thread first = new Thread(() ->
                System.out.println("First total: " + service.calculateTotal(100, 10)));
        Thread second = new Thread(() ->
                System.out.println("Second total: " + service.calculateTotal(200, 20)));

        first.start();
        second.start();
        first.join();
        second.join();
    }

    public static void hashMapVsConcurrentHashMapExample() throws InterruptedException {
        System.out.println("Expected purchases: " + 200_000);
        System.out.println("HashMap: " + countPurchases(new HashMap<>()));
        System.out.println("ConcurrentHashMap: " + countPurchases(new ConcurrentHashMap<>()));
        System.out.println("HashMap can lose updates; its result varies and may be correct by chance.");
    }

    private static int countPurchases(Map<String, Integer> purchases) throws InterruptedException {
        purchases.put("laptop", 0);
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                // Add 1 to the existing value for this key.
                // HashMap.merge() is not thread safe; ConcurrentHashMap.merge() is atomic.
                purchases.merge("laptop", 1, Integer::sum);
            }
        };

        Thread first = new Thread(task);
        Thread second = new Thread(task);
        first.start();
        second.start();
        first.join();
        second.join();
        return purchases.get("laptop");
        // Even on ConcurrentHashMap, get() followed by put() is NOT an atomic increment.
    }

    // In a Spring project, this service could be annotated with @Service.
    // This project uses plain Java, so no Spring annotation is needed here.
    public static class PricingService {
        public double calculateTotal(double price, double tax) {
            // Each call has its own parameters. No shared fields are modified.
            return price + tax;
        }
    }
}
