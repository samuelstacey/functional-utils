package com.functionaltools.functionalutils;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
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

    public <U> Identity<U> map(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return of(mapper.apply(value));
    }

    public <U> Identity<U> flatMap(Function<? super T, ? extends Identity<U>> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return mapper.apply(value);
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        requireNonNull(predicate, "predicate must not be null");
        return predicate.test(value) ? Optional.of(value) : Optional.empty();
    }

    public <U> U fold(Function<? super T, ? extends U> mapper) {
        requireNonNull(mapper, "mapper must not be null");
        return mapper.apply(value);
    }

    public T get() {
        return value;
    }

    public Stream<T> stream() {
        return Stream.of(value);
    }
}
