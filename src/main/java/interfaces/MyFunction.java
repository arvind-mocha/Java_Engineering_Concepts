package interfaces;

@FunctionalInterface
public interface MyFunction<R, T> {
    R apply(T input);
}
