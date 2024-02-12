package com.notebook.java._8.optional;

import com.notebook.core.dto.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class Demo001OptionalTest {

    @Nested
    @DisplayName("Creating instance using Optional")
    class CreatingInstances {

        @ParameterizedTest
        @ValueSource(strings = {"Gagan", "", "  "})
        @DisplayName("Optional.of() without null")
        void ofWithoutNull(String nonNullValue) {

            Optional<String> nonNullValueOptional = Optional.of(nonNullValue);
            Assertions.assertTrue(nonNullValueOptional.isPresent(), "");
            Assertions.assertEquals(nonNullValue, nonNullValueOptional.get(), "");
        }

        @NullSource
        @ParameterizedTest
        @DisplayName("Optional.of() with null")
        void ofWithNull(String name) {
            Assertions.assertThrows(NullPointerException.class, () -> Optional.of(name), "");
        }

        @MethodSource
        @ParameterizedTest
        @SuppressWarnings("SameParameterValue")
        @DisplayName("Optional.ofNullable() with or without null")
        void ofNullable(String name) {

            Optional<String> optionalNull = Optional.ofNullable(name);
            if (name == null) Assertions.assertThrows(NoSuchElementException.class, optionalNull::get, "");
            else Assertions.assertTrue(optionalNull.isPresent(), "");
        }

        @Test
        @DisplayName("Optional.empty()")
        void empty() {

            Optional<Employee> employee = Optional.empty();
            Assertions.assertFalse(employee.isPresent(), "");
            Assertions.assertThrows(NoSuchElementException.class, () -> employee.get(), "");
        }

        private static Stream<Arguments> ofNullable() {
            return Stream.of(
                    Arguments.of((String) null),
                    Arguments.of("Gagan"),
                    Arguments.of(" "),
                    Arguments.of("")
            );
        }
    }
}
