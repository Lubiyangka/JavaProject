public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;


    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Boolean isTriangle() {
        return this.sideB + this.sideA > this.sideC && this.sideA + this.sideC > this.sideB && this.sideB + this.sideC > this.sideA;
    }

    public double getArea() {
        if (isTriangle()) {
            return 0.25 * Math.sqrt((this.sideA + this.sideB + this.sideC) * (this.sideA + this.sideB - this.sideC) * (this.sideC + this.sideB - this.sideA) * (this.sideA + this.sideC - this.sideB));
        }
        else{
            return -1;
        }
    }

    public double getPerimeter(){
        if(isTriangle()) {
            return this.sideA + this.sideB + this.sideC;
        }
        else{
            return -1;
        }
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}
