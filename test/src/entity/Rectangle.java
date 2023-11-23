package entity;

public class Rectangle extends Geometry {
    private double a;
    private double b;

    public double getArea() {
        return this.a * this.b;
    }
    public void pr(){
        System.out.println("Circle");
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
}
