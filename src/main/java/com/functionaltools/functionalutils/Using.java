package com.functionaltools.functionalutils;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public final class Using<T> {

    private final T value;

    private Using(T value) {
        this.value = requireNonNull(value, "Using value must not be null");
    }

    public static <T> Using<T> using(T value) {
        requireNonNull(value, "Using value must not be null");
        return new Using<>(value);
    }

    public T get() {
        return value;
    }

    public <U> Using<U> map(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return using(mapper.apply(value));
    }

    public <U> U in(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return mapper.apply(value);
    }

//    public Identity<T> filter(Predicate<? super T> predicate) {
//        requireNonNull(predicate, "predicate must not be null");
//        return predicate.test(value) ? this : empty();
//    }

//    public static<T> Identity<T> empty() {
//        Identity<T> t = (Identity<T>) EMPTY;
//        return t;
//    }

    public Stream<T> stream() {
        return Stream.of(value);
    }
}
