package com.functionaltools.functionalutils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class IdentityTest {

    @Test
    void valueMustNotBeNull() {
    assertThatNullPointerException()
        .isThrownBy(() -> Identity.of(null))
        .withMessage("Identity value must not be null");
    }

    @Test
    void mapperMustNotBeNull() {
    assertThatNullPointerException()
        .isThrownBy(() -> Identity.of(new Object()).map(null))
        .withMessage("mapper must not be null");
    }
}