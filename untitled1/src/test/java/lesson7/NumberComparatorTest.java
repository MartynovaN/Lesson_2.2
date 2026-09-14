package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {

    @Test
    void shouldReturnMinusOneWhenFirstNumberIsLess() {
        NumberComparator comparator = new NumberComparator();

        int result = comparator.compare(5, 10);

        assertEquals(-1, result);
    }

    @Test
    void shouldReturnOneWhenFirstNumberIsGreater() {
        NumberComparator comparator = new NumberComparator();

        int result = comparator.compare(10, 5);

        assertEquals(1, result);
    }

    @Test
    void shouldReturnZeroWhenNumbersAreEqual() {
        NumberComparator comparator = new NumberComparator();

        int result = comparator.compare(5, 5);

        assertEquals(0, result);
    }
}