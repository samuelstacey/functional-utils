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

    //Where possible replace this call and the previous map with an in()
    public T get() {
        return value;
    }

    public <U> Using<U> map(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return using(mapper.apply(value));
    }

    public <U> Using<T> peek(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        mapper.apply(value);
        return using(value);
    }

    //TODO: rename this before release
    public Using<T> avert(Function<? super T, Void> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        mapper.apply(value);
        return using(value);
    }

    public <U> U in(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return mapper.apply(value);
    }

    public Stream<T> stream() {
        return Stream.of(value);
    }
}
