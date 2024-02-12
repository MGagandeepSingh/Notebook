package com.notebook.junit._5;

import com.notebook.core.dto.Designation;
import com.notebook.core.dto.Employee;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// This is the way to give your test cases some name.
@DisplayName("Various JUnit 5 features you can use")
public class VariousTests {

    // Nested annotation is used to set a class as a nested test class.
    @Nested
    @DisplayName("Creating a nested test cases")
    class NestedTestCases {

        @Test
        void simpleTest() {
            assertTrue(true, "This test case can never fail");
        }
    }

    @Nested
    @DisplayName("Parameterized test cases")
    class ParameterizedTestCases {

        // Defining the data set through annotation
        // For parameterized we don't need to use @Test, instead we can use @ParameterizedTest
        @ParameterizedTest
        @DisplayName("Parameterized test with annotation data set")
        // You can use all primitive types lik (booleans, strings etc) and classes too.
        @ValueSource(ints = {1, 3, 5, -15})
        void oddNumbers(int number) {
            assertNotEquals(0, number % 2, "This is not an odd number");
        }

        // We have special annotations for Empty and Null parameters
        @NullSource
        @EmptySource
        @DisplayName("Test username is empty")

        // When you need to check the values passed to the test case.
        @ParameterizedTest(name = "When passing in username as: {0}")
        void checkEmpty(String username) {
            assertTrue(StringUtils.isEmpty(username), "Username is not empty, but should be empty");
        }

        // You can also pass in the value via Enum too.
        @ParameterizedTest
        @EnumSource(value = Designation.class, names = {"SWD"})
        void designationTest(Designation designation) {

            var employee = Employee.builder().designation("Software Developer").build();
            assertEquals(designation.getTitle(), employee.designation(), "Undefined designation found");
        }


        @ValueSource()
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
