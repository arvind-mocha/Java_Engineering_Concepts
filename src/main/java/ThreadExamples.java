import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExamples {
    public static void threadExample() throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Worker thread: " + i);
            }
        });
        // Currently running the main thread
        worker.start(); // Starts a new thread; run() would use the current thread.
        worker.join(); // Main waits until worker finishes, because now we are in main thread
        for (int i = 1; i <= 3; i++) {
            System.out.println("Main thread: " + i);
        }

        // The order of messages can change from one run to the next.
    }

    public static void runnableVsCallableExample() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            // Runnable.run() does work but returns no value.
            Runnable runnable = () -> System.out.println("Runnable: doing some work");
            Future<?> runnableFuture = executor.submit(runnable);
            runnableFuture.get(); // Waits for the task to finish; its result is null.

            // Callable.call() can return a value and throw checked exceptions.
            Callable<Integer> callable = () -> 5 + 3;
            Future<Integer> callableFuture = executor.submit(callable);
            Integer result = callableFuture.get(); // Waits and retrieves the result.
            System.out.println("Callable result: " + result);
        } finally {
            executor.shutdown(); // Release the executor's worker thread after its tasks finish.
        }
    }

// ------------------------ SYNCHRONIZATION ------------------------------

    public static void synchronizationExample() throws InterruptedException {
        System.out.println("Unsynchronized: two customers buying the last laptop");
        Inventory unsafeInventory = new Inventory();
        runPurchases(unsafeInventory, false);
        System.out.println("Remaining stock: " + unsafeInventory.stock);

        System.out.println("\nSynchronized: two customers buying the last laptop");
        Inventory safeInventory = new Inventory();
        runPurchases(safeInventory, true);
        System.out.println("Remaining stock: " + safeInventory.stock);
        System.out.println("The unsynchronized version can oversell; timing determines the outcome.");
    }

    private static void runPurchases(Inventory inventory, boolean useSynchronization)
            throws InterruptedException {
        Runnable purchase = () -> {
            try {
                if (useSynchronization) {
                    inventory.purchaseSynchronized();
                } else {
                    inventory.purchase();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Both customers must share the SAME inventory object.
        Thread first = new Thread(purchase, "Alice");
        Thread second = new Thread(purchase, "Bob");
        first.start();
        second.start(); // Start both before waiting, so they can run concurrently.
        first.join();
        second.join(); // Wait for both purchases before reading remaining stock.
    }

    private static class Inventory {
        private int stock = 1;

        void purchase() throws InterruptedException {
            String customer = Thread.currentThread().getName();
            if (stock > 0) {
                // Simulate processing so the race is easier to see; sleep releases no locks.
                Thread.sleep(100);
                stock--;
                System.out.println(customer + " purchased a laptop.");
            } else {
                System.out.println(customer + ": out of stock.");
            }
        }

        synchronized void purchaseSynchronized() throws InterruptedException {
            // Hold this inventory's lock across BOTH the stock check and the update.
            purchase();
        }
    }

    // ---------------------------- VOLATILE ----------------------------------

    public static void volatileExample() throws InterruptedException {
        StoppableWorker task = new StoppableWorker();
        Thread worker = new Thread(task, "Volatile worker");
        worker.start();

        try {
            Thread.sleep(100); // Give the worker time to run; sleep doesn't ensure visibility.
        } finally {
            System.out.println("Main: requesting worker to stop.");
            task.requestStop();
            worker.join(); // Wait for the worker to observe the flag and finish.
        }
        System.out.println("Main: worker has finished.");
    }

    static int runningCounter = 0;
    private static class StoppableWorker implements Runnable {
        // Main writes this flag; the worker reads it. volatile makes changes visible.
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                runningCounter ++;
            }
            System.out.println("Worker: observed running = false and stopped.");
            System.out.println("Total number of running loop count: " + runningCounter);
        }

        void requestStop() {
            running = false;
        }

        // Without volatile, the loop is not guaranteed to observe main's update.
        // volatile does NOT make compound operations such as count++ atomic.
    }

    public static void volatileCounterExample() throws InterruptedException {
        VolatileCounter counter = new VolatileCounter();
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };

        Thread first = new Thread(task);
        Thread second = new Thread(task);
        first.start();
        second.start();
        first.join();
        second.join();

        System.out.println("Expected: " + 200_000);
        System.out.println("Actual with volatile count++: " + counter.count);
        System.out.println("Updates can be lost; the result varies and may be correct by chance.");
    }

    public static void atomicCounterExample() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.incrementAndGet(); // Atomic increment: no updates are lost.
            }
        };

        // Both threads increment the same AtomicInteger.
        Thread first = new Thread(task);
        Thread second = new Thread(task);
        first.start();
        second.start();
        first.join();
        second.join();

        System.out.println("Expected: " + 200_000);
        System.out.println("Actual with AtomicInteger: " + counter.get());
    }

    private static class VolatileCounter {
        private volatile int count;

        void increment() {
            // volatile makes reads/writes visible, but doesn't make read-add-write atomic.
            // Both threads could read 0, then both write 1: one increment is lost.
            count++;
            // Use synchronized on this method or AtomicInteger.incrementAndGet() to fix it.
        }
    }

    // -------------------------- DEADLOCK ---------------------------------------

    public static void deadlockExample() throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();
        CountDownLatch bothLocked = new CountDownLatch(2);

        Thread first = deadlockingThread("First", lockA, lockB, bothLocked);
        Thread second = deadlockingThread("Second", lockB, lockA, bothLocked);
        first.start();
        second.start();

        while (first.getState() != Thread.State.BLOCKED
                || second.getState() != Thread.State.BLOCKED) {
            Thread.sleep(10);
        }
        System.out.println("Deadlock: First holds A and waits for B; Second holds B and waits for A.");
        // Do not join(): neither thread can finish. Always use the same lock order to prevent this.
    }

    private static Thread deadlockingThread(String name, Object firstLock, Object secondLock,
                                            CountDownLatch bothLocked) {
        Thread thread = new Thread(() -> {
            synchronized (firstLock) {
                System.out.println(name + " acquired its first lock.");
                bothLocked.countDown();
                try {
                    bothLocked.await(); // Both threads hold their first lock before proceeding.
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                synchronized (secondLock) { // Each waits for the lock held by the other.
                    System.out.println(name + " acquired both locks."); // Never reached.
                }
            }
        }, name);
        thread.setDaemon(true); // Allows JVM exit; the deadlock itself remains unresolved.
        return thread;
    }

    public static void preventDeadlockExample() throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();

        Runnable task = () -> {
            // Both threads acquire A first, then B: no circular waiting.
            synchronized (lockA) {
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + " acquired both locks.");
                }
            } // Both locks are released when their synchronized blocks end.
        };

        Thread first = new Thread(task, "First");
        Thread second = new Thread(task, "Second");
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Both threads finished without deadlock.");
    }

    public static void fairReentrantLockExample() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true); // true enables fairness.
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                lock.lock(); // Under contention, favors the longest-waiting thread.
                try {
                    System.out.println(Thread.currentThread().getName() + " holds the lock, round " + i);
                    Thread.sleep(20); // Demo only: give the other thread time to queue.
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } finally {
                    lock.unlock(); // Always release the lock, even if the task fails.
                }
            }
        };

        Thread first = new Thread(task, "First");
        Thread second = new Thread(task, "Second");
        first.start();
        second.start();
        first.join();
        second.join();
        // Fairness concerns waiting threads, not start order or guaranteed alternation.
        // Reentrant means the owning thread can acquire this lock again (and must unlock again).
    }

    public static void threadPriorityExample() throws InterruptedException {
        Runnable task = () -> {
            Thread current = Thread.currentThread();
            for (int i = 1; i <= 3; i++) {
                System.out.println(current.getName() + " (priority " + current.getPriority() + "): " + i);
            }
        };

        Thread low = new Thread(task, "Low priority");
        Thread high = new Thread(task, "High priority");
        low.setPriority(Thread.MIN_PRIORITY); // 1; default priority is usually 5.
        high.setPriority(Thread.MAX_PRIORITY); // 10.

        low.start();
        high.start();
        low.join();
        high.join();
        System.out.println("Priority is a scheduling hint; high priority is NOT guaranteed to run first.");
        // The JVM/OS may ignore priorities. Use coordination when execution order matters.
    }

    public static void tryLockExample() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Runnable task = () -> {
            if (lock.tryLock()) { // Returns immediately: true if I acquired, false if busy.
                try {
                    System.out.println(Thread.currentThread().getName() + ": acquired the lock.");
                } finally {
                    lock.unlock(); // Unlock only if this thread acquired it.
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": lock busy, doing other work.");
            }
        };

        lock.lock(); // Main holds the lock so the worker's attempt will fail.
        try {
            Thread worker = new Thread(task, "Worker");
            worker.start();
            worker.join(); // Safe here because tryLock() doesn't wait for main's lock.
        } finally {
            lock.unlock();
        }

        task.run(); // Main tries after releasing the lock: this attempt succeeds.
    }
}
