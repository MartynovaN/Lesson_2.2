package lesson7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    private Factorial factorial;

    @BeforeMethod
    public void setUp() {
        factorial = new Factorial();
    }

    @AfterMethod
    public void tearDown() {
        factorial = null;
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {10, 3628800}
        };
    }

    @Test(dataProvider = "factorialData")
    public void shouldCalculateFactorial(int number, int expected) {
        assertEquals(factorial.calculate(number), expected);
    }

    @Test
    public void shouldThrowExceptionForNegativeNumber() {
        assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calculate(-1)
        );
    }
}