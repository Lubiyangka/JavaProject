public class Circle {
    double r;
    double area;
    private double perimeter;
    public Circle(){

    }
    public Circle(double r){
        this.r = r;
        this.area = Math.PI*r*r;
        this.perimeter = Math.PI*r*2;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    public static int add(double r){
        return (int) r;
    }
    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
