package ThreadDemo;

public class Java8Demo {
    public static void main(String[] args) {
        Runnable task = ()->{
            System.out.println("Executing in "+Thread.currentThread().getName());
        };
        new Thread(task).start();
        new Thread(task).start();
    }
}
