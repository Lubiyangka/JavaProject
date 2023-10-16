public class Main {
    int id;
    String name;
    static int counter = 0;

    public Main(int id, String name) {
        this.id = id;
        this.name = name;
        counter++;
    }
    public void print(){
        MC mc = new MC();
        mc.print();
    }

    class MC{
        String name;
        public void print(){
            System.out.println("id="+id+",name="+Main.this.name);
            System.out.println("counter"+counter);
        }
    }

    public static void main(String[] args){
//        Pillar pillar;
//        Geometry bottom;
//
//        bottom = new Rectangle(12,12);
//        pillar = new Pillar(bottom, 60);
//        System.out.println(pillar.getVolume());
//        bottom = new Circle(13);
//        pillar = new Pillar(bottom, 1);
//        System.out.println(pillar.getVolume());
        Main main1 = new Main(1,"Tom");
        main1.print();
        Main main2 = new Main(2,"Tkk");
        main2.print();
        Main main = new Main(3,"jj");
        Main.MC mc =main.new MC();
        mc.print();

    }
}
