package lesson2_4;

public interface Shape {

    double getArea();

    double getPerimeter();

    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
    }
}