package InterfaceDemo;

public class CardPayment implements Payment{
    public void pay(){
        System.out.println(Payment.x);
    }
}
