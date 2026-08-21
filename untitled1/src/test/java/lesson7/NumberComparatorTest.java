package lesson7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTest {

    private NumberComparator comparator;

    @BeforeMethod
    public void setUp() {
        comparator = new NumberComparator();
    }

    @AfterMethod
    public void tearDown() {
        comparator = null;
    }

    @Test
    public void shouldReturnMinusOneWhenFirstNumberIsSmaller() {
        assertEquals(comparator.compare(5, 10), -1);
    }

    @Test
    public void shouldReturnOneWhenFirstNumberIsGreater() {
        assertEquals(comparator.compare(10, 5), 1);
    }

    @Test
    public void shouldReturnZeroWhenNumbersAreEqual() {
        assertEquals(comparator.compare(5, 5), 0);
    }
}