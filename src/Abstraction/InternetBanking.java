package Abstraction;

public class InternetBanking extends Payment{
    @Override
    void pay() {
        System.out.println("payment");
    }
}
