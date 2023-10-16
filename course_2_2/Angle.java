public class Angle extends Circle{
    int id;

    public Angle() {
    }

    public Angle(int id, double r){
        super(r);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Angle{" +
                "id=" + id +
                ", r=" + r +
                ", area=" + area +
                '}';
    }
}
