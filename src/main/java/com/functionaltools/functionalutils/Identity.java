package com.functionaltools.functionalutils;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public final class Identity<T> {

    private final T value;

    private Identity(T value) {
        this.value = requireNonNull(value, "Identity value must not be null");
    }

    public static <T> Identity<T> of(T value) {
        requireNonNull(value, "Identity value must not be null");
        return new Identity<>(value);
    }

    public T get() {
        return value;
    }

    public <U> Identity<U> map(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return of(mapper.apply(value));
    }

    public <U> U in(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return mapper.apply(value);
    }

    public Stream<T> stream() {
        return Stream.of(value);
    }
}
