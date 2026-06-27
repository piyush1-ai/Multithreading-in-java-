package ExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->readUserData());
        executorService.submit(()->readOrderedData());
        executorService.submit(()->readFromCache());
        executorService.submit(()->callNotificationService());
        executorService.submit(()->callPaymentService());
        executorService.submit(()->readFromFile());

        executorService.shutdown();

    }
    public static void readUserData()  {
        System.out.println("Reading user data from db:");
        sleep(2000);
        System.out.println("User db read completed ");
    }
    public static void readOrderedData()  {
        System.out.println("Reading ordered data from db:");
        sleep(1500);
        System.out.println("ordered db read completed ");

    }
    public static void callPaymentService() {
        System.out.println("Calling payment service");
        sleep(3000);
        System.out.println("payment service response received ");
    }
    public static void callNotificationService()  {
        System.out.println("Calling notification service");
        sleep(3000);
        System.out.println("notification service response received ");
    }
    public static void readFromCache()  {
        System.out.println("reading data form cache");
        sleep(3000);
        System.out.println("cache read completed ");
    }
    public static void readFromFile()  {
        System.out.println("reading data form file");
        sleep(3000);
        System.out.println("file read completed ");
    }
    private static void sleep(int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

//  =====================================================
        /*
        problem with runnable:

        why runnable exists?
        you want to run a task in another thread  will use Runnable but...
        1.Don't care about return value.
        2.Don't care about result status.
        3.Don't want exception handling complexity

        Example: logging , email ,cache
        Runnable = fire and forget

         */
    }
}
