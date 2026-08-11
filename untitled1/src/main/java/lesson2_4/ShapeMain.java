package lesson2_4;

public class ShapeMain {

    public static void main(String[] args) {

        Circle circle = new Circle(
                5,
                "Красный",
                "Черный"
        );

        Rectangle rectangle = new Rectangle(
                10,
                5,
                "Синий",
                "Белый"
        );

        Triangle triangle = new Triangle(
                3,
                4,
                5,
                "Зеленый",
                "Черный"
        );

        System.out.println("=== КРУГ ===");
        circle.printInfo();
        System.out.println("Цвет заливки: " + circle.getFillColor());
        System.out.println("Цвет границы: " + circle.getBorderColor());

        System.out.println();

        System.out.println("=== ПРЯМОУГОЛЬНИК ===");
        rectangle.printInfo();
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());

        System.out.println();

        System.out.println("=== ТРЕУГОЛЬНИК ===");
        triangle.printInfo();
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет границы: " + triangle.getBorderColor());
    }
}