package com.functionaltools.functionalutils;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.apache.commons.lang3.Validate.notNull;

public final class Using<T> {

    private final T value;

    private Using(T value) {
        this.value = notNull(value, "Using value must not be null");
    }

    public static <T> Using<T> using(T value) {
        notNull(value, "Using value must not be null");
        return new Using<>(value);
    }

    public T get() {
        return value;
    }

    public <U> Using<U> map(Function<? super T, ? extends U> mapper) {
        notNull(mapper, "mapper must not be null");
        return using(mapper.apply(value));
    }

    public <U> U in(Function<? super T, ? extends U> mapper) {
        notNull(mapper, "mapper must not be null");
        return mapper.apply(value);
    }

//    public Identity<T> filter(Predicate<? super T> predicate) {
//        notNull(predicate, "predicate must not be null");
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
