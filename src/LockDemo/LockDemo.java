package LockDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockDemo{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        BankAccount account = new BankAccount();
        executor.submit(()->account.withdraw(500));
        executor.submit(()->account.withdraw(400));
        executor.submit(()->account.withdraw(100));

        System.out.println("I am doing something");
        executor.shutdown();
    }
}
