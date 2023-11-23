package entity;

public class Circle extends Geometry {
    private double r;

    public double getArea() {
        return Math.PI * r * r;
    }

    public void pr(){
        System.out.println("Circle");
    }

    public Circle(double r) {
        this.r = r;
    }
}
