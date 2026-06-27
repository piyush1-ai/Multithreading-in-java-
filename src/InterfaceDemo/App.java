package InterfaceDemo;

public class App {
    public static void main(String[] args) {
        Payment p = new UpiPayment(); // dynamic method dispatch --> child class object created
        p.pay();
        Payment q = new CardPayment();
        q.pay();
    }
}
