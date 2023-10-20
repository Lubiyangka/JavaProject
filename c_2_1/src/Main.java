public class Main {
    public static void main(String[] args){
        Pay pay = new Pay(200,0.15,0.0465);
        pay.computePayment(10);
        System.out.println(pay.getPayment());
        pay.computePayment(10,0.05);
        System.out.println(pay.getPayment());
        pay.computePayment(10,0.20,0.005);
        System.out.println(pay.getPayment());
    }
}
