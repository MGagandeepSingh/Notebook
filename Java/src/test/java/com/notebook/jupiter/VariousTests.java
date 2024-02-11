package com.notebook.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Various JUnit 5 features you can use")
public class VariousTests {

    @Nested
    @DisplayName("Creating a nested test cases")
    class CreatingInstances {

        private static Stream<Arguments> dataSetForTesting() {

            return Stream.of(
                    Arguments.of("Gagandeep Singh", 15),
                    Arguments.of("Dararat Bunyok", 14)
            );
        }

        @DisplayName("Test Get ID for correct email and product name input")
        @ParameterizedTest(name = "Name: {0} has length: {1}")
        @MethodSource(value = "dataSetForTesting")
        void getIdFromValidEmailAndProductName(String username, int expectedLength) {

            assertEquals(username.length(), expectedLength, "Incorrect character count");
        }
    }
}
