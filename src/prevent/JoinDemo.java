package prevent;
/*
The join method allows one thread to completion of another thread
when a thread calls join another thread , it will block until complete
its task or execution
 */
class WashingMachine extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("Washing started...");
            Thread.sleep(3000); // just sleep for 3 second
            System.out.println("washing finished...");
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        WashingMachine wash = new WashingMachine();
                wash.start();
                wash.join();
//                wash.join(2000); // college friend
//                wash.join(1000,200); // office friend
        System.out.println("Now start drying");
    }
}
