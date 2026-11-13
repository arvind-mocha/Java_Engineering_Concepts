import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
}
