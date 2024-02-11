package com.notebook.java._8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Demo001OptionalTest {

    @Nested
    @DisplayName("Creating instance using Optional")
    class CreatingInstances {

        @Test
        @DisplayName("Optional.of() without null")
        void of() {

            final String nonNull = "Gagan";
            Optional<String> nonNullValue = Optional.of(nonNull);
            Assertions.assertTrue(nonNullValue.isPresent(), "");
            Assertions.assertEquals(nonNull, nonNullValue.get(), "");
        }

        @Test
        @DisplayName("Optional.of() with null")
        void ofNull() {
            Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null), "");
        }

        @Test
        @DisplayName("Optional.empty()")
        void empty() {

            Optional<String> empty = Optional.empty();
            Assertions.assertFalse(empty.isPresent(), "");
            Assertions.assertThrows(NoSuchElementException.class, () -> empty.get(), "");
        }
    }
}
