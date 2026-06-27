package prevent;

class  TeaMaker extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("Boiling water ...");
            Thread.sleep(5000);
            System.out.println(" Tea is ready... ");
        } catch (InterruptedException e) {
            System.out.println("Tea Making interrupted... ");
        }
    }
}
public class SleepDemo {
    public static void main(String[] args) {
        TeaMaker t = new TeaMaker();
        t.start();
//        t.interrupt();
    }
}
