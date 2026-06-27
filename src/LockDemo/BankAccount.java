package LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 1000;
    private final Lock lock = new ReentrantLock();

    void withdraw(int amount) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " entered");
            balance = balance - amount;
            System.out.println("balance after withdrawal : " + balance);
        } finally {
            lock.unlock();
        }
    }
}

