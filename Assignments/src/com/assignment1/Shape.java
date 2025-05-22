package com.assignment1;

public class Shape {
    public double calArea(Triangle t){
        return ((0.5) * t.getBase() * t.getHeight());
    }
    public double calArea(Rectangle r){
        return (r.getBreadth() * r.getLength());
    }
    public double calArea(Circle c){
        return (2 * 3.14 * c.getRadius() * c.getRadius());
    }

    public static void main(String[] args) {
        Shape sh = new Shape();
        Circle c1 = new Circle(15.4);
        Triangle t1 = new Triangle(15.2,16.2);
        Rectangle r1 = new Rectangle(55.2,65.3);

        double area1=sh.calArea(c1);
        double area2=sh.calArea(t1);
        double area3=sh.calArea(r1);

        System.out.println("Area of circle " + area1);
        System.out.println("Area of triangle " + area2);
        System.out.println("Area of rectangle " + area3);
    }
}
class Triangle{
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}
class Rectangle{
    double length;
    double breadth;

    public Rectangle(double breadth, double length) {
        this.breadth = breadth;
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public double getLength() {
        return length;
    }
}
class Circle{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
