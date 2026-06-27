package ReturnDemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SalaryService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Callable<String>  SalaryTask = ()->{
            System.out.println("Calculating salary by "+Thread.currentThread().getName());
            Thread.sleep(1000);
            return "45000.0";
        };
        Callable<String>  email = ()->{
            System.out.println(" sending email by... "+Thread.currentThread().getName());
            Thread.sleep(1000);
            return "Done";
        };
        List<Callable<String>> tasks = Arrays.asList(SalaryTask,email);
        List <Future<String>> results = executor.invokeAll(tasks);

//        executor.submit(SalaryTask);
//        Future<Double> submit = executor.submit(SalaryTask);
        System.out.println("Hr doing Rangoli work...");
//        Double sal = submit.get();
        System.out.println("---------------Final results----------------");
        for(Future<String> future: results){
            System.out.println(future.get());
        }
//        System.out.println("Final salary = " +sal);
        executor.shutdown();
    }
}
