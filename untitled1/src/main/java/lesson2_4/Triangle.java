package lesson2_4;

public class Triangle extends ColoredShape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC,
                    String fillColor, String borderColor) {

        super(fillColor, borderColor);

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {

        double halfPerimeter = (sideA + sideB + sideC) / 2;

        return Math.sqrt(
                halfPerimeter
                        * (halfPerimeter - sideA)
                        * (halfPerimeter - sideB)
                        * (halfPerimeter - sideC)
        );
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
}