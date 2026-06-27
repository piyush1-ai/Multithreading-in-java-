package ReturnDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableReturnDemo
{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable emailTask = ()->{
            System.out.println("Sending email "+Thread.currentThread().getName());
        };
        executorService.submit(emailTask);
        executorService.shutdown();
    }
}
