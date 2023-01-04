// FractalDrawer class draws a fractal of a shape indicated by user input
// Implemented by Curtis Kokuloku, kokul003

import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    private static double totalArea = 0; // member variable for tracking the total area
    public static double x; // instantiating x, y position, level, color, and divider
    public static double y;
    public static int level;
    public static Color c;

    public FractalDrawer() {
        x = 500.0;
        y = 500.0;
        level = 9;
        c = choosingRandomColor();
    } // constructor

    // drawFractal creates a new Canvas object and determines which shapes to
    // draw a fractal by calling appropriate
    // helper function; drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Scanner myScanner = new Scanner(System.in);

        switch (type) {
            case "circle", "Circle" -> {
                System.out.println("Enter the radius you want for the circle: ");
                double circleRadius = myScanner.nextDouble();
                Canvas can = new Canvas(1200, 1200);
                this.drawCircleFractal(circleRadius, x, y, c, can, level);
                break;
            }
            case "triangle", "Triangle" -> {
                System.out.println("Enter the width you want for the triangle: ");
                double triangleWidth = myScanner.nextDouble();
                System.out.println("Enter the height you want for the triangle: ");
                double triangleHeight = myScanner.nextDouble();
                Canvas can = new Canvas(1200, 1200);
                this.drawTriangleFractal(triangleWidth, triangleHeight, x, y, c, can, level);
                break;
            }
            case "rectangle", "Rectangle" -> {
                System.out.println("Enter the width you want for the rectangle: ");
                double rectangleWidth = myScanner.nextDouble();
                System.out.println("Enter the height you want for the rectangle: ");
                double rectangleHeight = myScanner.nextDouble();
                Canvas can = new Canvas(1200, 1200);
                this.drawRectangleFractal(rectangleWidth, rectangleHeight, x, y, c, can, level);
                break;
            }
        }
        myScanner.close();
        return totalArea;
    }

    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Triangle myTriangle = new Triangle(x, y, width, height);
        myTriangle.setColor(c);
        can.drawShape(myTriangle);
        c = choosingRandomColor();
        totalArea += myTriangle.calculateArea();
        level--;
        if (level != 0) {
            drawTriangleFractal(width / 2, height / 2, x - (width / 2), y, c, can, level);
            drawTriangleFractal(width / 2, height / 2, x + (width), y, c, can, level);
            drawTriangleFractal(width / 2, height / 2, x + (width / 4), y - (width), c, can, level);
        }
    }

    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle myCircle = new Circle(x, y, radius);
        myCircle.setColor(c);
        can.drawShape(myCircle);
        c = choosingRandomColor();
        totalArea += myCircle.calculateArea();
        level -= 1;
        if (level != 0) {
            drawCircleFractal(radius / 2, x - radius, y, c, can, level);
            drawCircleFractal(radius / 2, x + radius, y, c, can, level);
            drawCircleFractal(radius / 2, x, y + radius, c, can, level);
            drawCircleFractal(radius / 2, x, y - radius, c, can, level);
        }
    }

    // drawRectangleFractal draws a rectangle fractal using recursive
    // techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle myRectangle = new Rectangle(x, y, width, height);
        myRectangle.setColor(c);
        can.drawShape(myRectangle);
        c = choosingRandomColor();
        totalArea += myRectangle.calculateArea();
        level--;
        if (level != 0) {
            drawRectangleFractal(width / 2, height / 2, x - (width / 2), y + width, c, can, level);
            drawRectangleFractal(width / 2, height / 2, x - (width / 2), y - (width / 2), c, can, level);
            drawRectangleFractal(width / 2, height / 2, x + width, y - (width / 2), c, can, level);
            drawRectangleFractal(width / 2, height / 2, x + width, y + (width), c, can, level);
        }
    }

    public static Color choosingRandomColor() {
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);

        return new Color(red, green, blue);
    } // helper function to get a random color

    // main should ask user for shape input, and then draw the corresponding
    // fractal. should print area of fractal
    public static void main(String[] args) {
        FractalDrawer myFractal = new FractalDrawer();
        System.out.println("Which shape do you want to draw? ");
        Scanner myScanner = new Scanner(System.in);
        String shape = myScanner.nextLine();
        System.out.println(myFractal.drawFractal(shape));
        myScanner.close();
    }
}
