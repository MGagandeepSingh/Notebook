# Code snippets for JUnit 5

- Display the name of the test case 
  - @DisplayName
  - Can be used for test cases and class
- Nested test cases 
  - @Nested
  - When you have more than one check
  - When you need to segregate the test cases into different categories.
- Parameterized Tests 
  - @ParameterizedTest
  - Log the passed in parameters value 
    - @ParameterizedTest(name = "When username passed is: {0}, then expected: {1}")
- Passing parameters from various sources
  - @EmptySource: Passing in ""
  - @NullSource: Passing in null
  - @EmptyAndNullSource
  - @EnumSource: You can pass in an enum
    - @EnumSource(value = Designation.class, names = {"SWD"})
    - This would pass in few values
  - @CsvSource: For pairs
  - @MethodSource: Using another method's output as input source.