import entity.Geometry;

public class Pillar {
    Geometry geometry;
    double height;

    public Pillar(Geometry geometry, double height) {
        this.geometry = geometry;
        this.height = height;
    }

    public double getVolume() {
        return this.geometry.getArea() * height;
    }
}

