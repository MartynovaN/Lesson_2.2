package lesson7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void shouldAddNumbers() {
        assertEquals(calculator.add(10, 5), 15);
    }

    @Test
    public void shouldSubtractNumbers() {
        assertEquals(calculator.subtract(10, 5), 5);
    }

    @Test
    public void shouldMultiplyNumbers() {
        assertEquals(calculator.multiply(10, 5), 50);
    }

    @Test
    public void shouldDivideNumbers() {
        assertEquals(calculator.divide(10, 5), 2);
    }
}