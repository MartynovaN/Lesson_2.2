package lesson7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleTest {

    private Triangle triangle;

    @BeforeMethod
    public void setUp() {
        triangle = new Triangle();
    }

    @AfterMethod
    public void tearDown() {
        triangle = null;
    }

    @Test
    public void shouldCalculateTriangleArea() {
        double result = triangle.calculateArea(10, 5);

        assertEquals(result, 25.0);
    }

    @Test
    public void shouldCalculateTriangleAreaForDifferentValues() {
        double result = triangle.calculateArea(6, 4);

        assertEquals(result, 12.0);
    }
}