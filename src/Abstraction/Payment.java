package Abstraction;

abstract class Payment {
    int a;
    Payment(){
        System.out.println("Constructor loading...");
    }
    abstract void pay(); // dependent on other --> that's why we cannot make object
//    --> we override method --> dynamic method dispatch
    public void invoice(){
        System.out.println("Bill generate");
    }
}
