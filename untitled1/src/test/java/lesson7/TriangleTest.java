package lesson7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    void shouldCalculateTriangleArea() {
        Triangle triangle = new Triangle();

        double result = triangle.calculateArea(10, 5);

        assertEquals(25.0, result);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 25.0",
            "6, 4, 12.0",
            "8, 3, 12.0",
            "5, 5, 12.5"
    })
    void shouldCalculateTriangleAreaForDifferentValues(
            double base,
            double height,
            double expected) {

        Triangle triangle = new Triangle();

        double result = triangle.calculateArea(base, height);

        assertEquals(expected, result);
    }
}