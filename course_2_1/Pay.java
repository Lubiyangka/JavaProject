public class Pay {
    private final double price;
    private final double withhold_rate;
    private final double pay_rate;
    private double payment;

    public Pay(double price, double withhold_rate, double pay_rate) {
        this.price = price;
        this.withhold_rate = withhold_rate;
        this.pay_rate = pay_rate;
    }

    public double computePayment(int time, double withhold_rate, double pay_rate) {
        return this.payment = time * this.price * (1 - withhold_rate) * (1 - pay_rate);
    }

    public double computePayment(int time, double pay_rate) {
        return this.payment = time * this.price * (1 - this.withhold_rate) * (1 - pay_rate);
    }

    public double computePayment(int time) {
        return this.payment = time * this.price * (1 - this.withhold_rate) * (1 - this.pay_rate);
    }

    public double getPayment() {
        return payment;
    }
}
