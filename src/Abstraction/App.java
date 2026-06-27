package Abstraction;

public class App {
    //    Payment p = new Payment() --> payment class is abstract that's why we cannot made object
    public static void main(String[] args) {
        Payment p = new CardPayment(); // object of child class refer to parent class
        p.invoice();
        p.pay();
    }
}
