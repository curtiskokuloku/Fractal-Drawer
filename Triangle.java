// Implemented by Curtis Kokuloku, kokul003

import java.awt.*;

public class Triangle {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Triangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter() {
        return width + Math.sqrt(Math.pow(width, 2) + (4 * Math.pow(height, 2)));
    }

    public double calculateArea() {
        return (width * height) / 2;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
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

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

}
