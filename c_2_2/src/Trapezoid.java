public class Trapezoid {
    private final double sideU;
    private final double sideD;
    private final double height;
    public double getArea(){
        return (sideD+sideU)*height*0.5;
    }

    public Trapezoid(double sideU, double sideD, double height) {
        this.sideU = sideU;
        this.sideD = sideD;
        this.height = height;
    }

}
