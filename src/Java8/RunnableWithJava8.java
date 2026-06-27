package Java8;

public class RunnableWithJava8 {
    public static void main(String[] args) {
        Runnable r = ()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Task");
            }
        };
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i <5; i++) {
            System.out.println("main");
        }
    }
}
