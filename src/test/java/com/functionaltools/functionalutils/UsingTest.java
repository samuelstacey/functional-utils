package com.functionaltools.functionalutils;

import org.junit.jupiter.api.Test;

import static com.functionaltools.functionalutils.Using.using;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class UsingTest {

    @Test
    void valueMustNotBeNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> using(null))
                .withMessage("Using value must not be null");
    }

    @Test
    void mapperMustNotBeNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> using(new Object()).map(null))
                .withMessage("mapper must not be null");
    }

}