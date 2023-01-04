// Implemented by Curtis Kokuloku, kokul003

import java.awt.*;

public class Circle {
    private double x;
    private double y;
    private double radius;
    private Color color;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double calculatePerimeter() {
        return (2 * Math.PI * radius);
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public double getXPos() {
        return x;
    }

    public double getYPos() {
        return y;
    }

    public double getRadius() {
        return radius;
    }
}
