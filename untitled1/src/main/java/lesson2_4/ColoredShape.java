package lesson2_4;

public abstract class ColoredShape implements Shape {

    protected String fillColor;
    protected String borderColor;

    public ColoredShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}