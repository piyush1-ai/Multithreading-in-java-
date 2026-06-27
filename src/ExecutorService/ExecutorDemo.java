package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable task1 =()->{
            String name = Thread.currentThread().getName();
            System.out.println("Task executes by "+name);
        };
//        Runnable task2 =()->{
//            String name = Thread.currentThread().getName();
//            System.out.println("Task executes by "+name);
//        };
//        Runnable task3 =()->{
//            String name = Thread.currentThread().getName();
//            System.out.println("Task executes by "+name);
//        };
//        executor.submit(task1);
//        executor.submit(task2);
//        executor.submit(task3);
        for (int i = 0; i < 6; i++) {
            executor.submit(task1);
        }
        executor.shutdown();
    }
}
