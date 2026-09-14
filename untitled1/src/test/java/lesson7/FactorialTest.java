package lesson7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    void shouldCalculateFactorial() {
        Factorial factorial = new Factorial();

        int result = factorial.calculate(5);

        assertEquals(120, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "5, 120",
            "10, 3628800"
    })
    void shouldCalculateFactorialForDifferentNumbers(int number, int expected) {
        Factorial factorial = new Factorial();

        int result = factorial.calculate(number);

        assertEquals(expected, result);
    }

    @Test
    void shouldThrowExceptionForNegativeNumber() {
        Factorial factorial = new Factorial();

        assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calculate(-1)
        );
    }
}