# Java Engineering Examples

Small, runnable Java examples for learning object-oriented programming, collections, lambdas, functional interfaces, streams, and concurrency. The examples are under `src/main/java`; `Main.java` selects which ones to run.

## Concepts covered

| File | Concepts | Try this while learning |
| --- | --- | --- |
| `Oops.java` and `Models/`, `interfaces/` | Inheritance and overriding (`Animal`, `Dog`, `Cat`); upcasting and checked downcasting; abstract classes and interfaces (`Shape`, `Drawable`, `Circle`); static versus instance state (`Counter`). | Predict which `speak()` implementation runs and compare the two counters' values. |
| `CollectionFramework.java` | `List` order and duplicates, `Set` uniqueness, `Map` keys and replacement, `HashMap` operations, FIFO `Queue`, and sorting with `Comparable` versus `Comparator`. | Add a duplicate or change the sort rule, then predict the printed collection. |
| `LambdaExamples.java` | A lambda implementing `Comparator<Student>`. | Rewrite the age comparison using `Comparator.comparingInt(Student::getAge)`. |
| `FunctionalInterface.java` and `interfaces/MyFunction.java` | `Predicate`, `Function`, `Consumer`, `Supplier`, a custom functional interface, lambdas, and method references. | Identify each interface's input and output; swap a lambda for the equivalent method reference. |
| `StreamExamples.java` | Stream pipelines: `filter`, `map`, `distinct`, `sorted`, `limit`, `count`, `anyMatch`, `findFirst`, `reduce`, and `toList`. | Predict the result of each pipeline before running it. Change the input students and check which results change. |
| `ThreadExamples.java` | `Thread` and `join`; `Runnable` versus `Callable`/`Future`; `synchronized`; `volatile` visibility versus atomicity; `AtomicInteger`; deadlock and lock ordering; fair `ReentrantLock`, `tryLock`, thread priority, and `CompletableFuture`. | Run one method at a time. Repeat race-condition examples and compare expected and actual counts. |
| `ThreadSafety.java` | Shared services with local state, `HashMap` races, and atomic `ConcurrentHashMap.merge`. | Compare the two map counts with the expected 200,000. |

## Thread safety: `ThreadSafety.java`

This class shows what happens when two threads use the same object or collection.

| Concept | Example | What to notice |
| --- | --- | --- |
| Shared object, independent calls | `threadSafetyExample()` | Both threads call one `PricingService`, but `calculateTotal` uses only its parameters and does not change shared state. Each call has its own values. |
| Starting and waiting for threads | Both examples | `start()` lets the threads run; `join()` waits for them to finish before the method returns or reads the result. Print order can change. |
| Race condition on shared data | `hashMapVsConcurrentHashMapExample()` | Two threads each add 100,000 purchases to the same map entry. `HashMap.merge` is unsafe for concurrent updates, so the result may be below 200,000 or otherwise unreliable. |
| Atomic map update | `hashMapVsConcurrentHashMapExample()` | `ConcurrentHashMap.merge` performs the update atomically for the key, producing the expected 200,000 purchases. A separate `get()` followed by `put()` would still be a compound operation and would not be an atomic increment. |

## Run the examples

From the project root, with a JDK installed:

```sh
./gradlew classes
java -cp build/classes/java/main Main
```

On Windows, use `gradlew.bat classes` for the first command and `java -cp build/classes/java/main Main` for the second. `Main` currently runs the two `ThreadSafety` examples followed by the synchronous/asynchronous example from `ThreadExamples`. Most other calls are commented out in `Main.java`; uncomment the example you want, rebuild, and run again. For clearer output, run one example at a time.

## Suggested learning path

1. Start with `Oops.java`: predict method dispatch, casting behavior, and static versus instance values.
2. Move to `CollectionFramework.java`, then `LambdaExamples.java`: compare collection behavior and the three ways this project sorts students (`Comparable`, a comparator class, and a lambda).
3. Run `FunctionalInterface.java` before `StreamExamples.java`. Find where the stream methods use predicates, functions, and consumers.
4. Run `ThreadExamples.java` methods individually, from basic threads through synchronization and atomic counters to locks and futures. `deadlockExample()` intentionally creates daemon threads that remain deadlocked; run it separately from other experiments.
5. Finish with `ThreadSafety.java`: predict both pricing totals and the expected purchase count. Run it repeatedly. Print order and the unsafe `HashMap` result can vary; a correct `HashMap` result on one run does not make it thread safe.

For each example, read the code, write down the expected output, run it, and change one input or operation at a time. Restore each experiment before moving on so later output remains easy to explain.
