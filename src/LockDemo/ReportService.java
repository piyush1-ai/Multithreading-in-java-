package LockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReportService {
    private final Lock lock = new ReentrantLock();
    public void generateReport() throws InterruptedException {
        if(lock.tryLock(3, TimeUnit.SECONDS)){
            try {
                System.out.println(Thread.currentThread().getName()+"Generating report ");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }else System.out.println(Thread.currentThread().getName()+"Could not get lock");
    }
}
