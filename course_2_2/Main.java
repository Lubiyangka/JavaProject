public class Main {
    public static void main(String[] args){
//        Triangle triangle = new Triangle(3.0,4.0,5.0);
//        Trapezoid trapezoid = new Trapezoid(3.0,4.0,5.0);
//        Circle circle=new Circle(3.0);
//        double v = 3.9;
//        System.out.println(Circle.add(4));
//        System.out.println("triangle`s area: "+triangle.getArea()+"; perimeter: "+triangle.getPerimeter());
//        System.out.println("trapezoid`s area: "+trapezoid.getArea());
//        System.out.println("circle`s area: "+circle.getArea()+"; perimeter: "+circle.getPerimeter());
//        Angle angle = new Angle(1,10.0);
//        System.out.println(angle.id+"  "+angle.r+"  "+ angle.area+"  "+angle.getArea()+"  "+angle.getPerimeter());
        m(new Fan());
        m(new Angle());
        m(new Circle());
        m(new Object());
    }
    public static void m(Object x){
        System.out.println(x.toString());
    }

}
