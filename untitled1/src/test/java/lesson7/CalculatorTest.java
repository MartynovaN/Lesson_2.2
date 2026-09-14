package lesson7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    void shouldAddNumbers() {
        int result = calculator.add(10, 5);

        assertEquals(15, result);
    }

    @Test
    void shouldSubtractNumbers() {
        int result = calculator.subtract(10, 5);

        assertEquals(5, result);
    }

    @Test
    void shouldMultiplyNumbers() {
        int result = calculator.multiply(10, 5);

        assertEquals(50, result);
    }

    @Test
    void shouldDivideNumbers() {
        int result = calculator.divide(10, 5);

        assertEquals(2, result);
    }

    @Test
    void shouldCalculateOnlyOnWindows() {
        assumeTrue(System.getProperty("os.name").contains("Windows"));

        int result = calculator.add(2, 3);

        assertEquals(5, result);
    }
}