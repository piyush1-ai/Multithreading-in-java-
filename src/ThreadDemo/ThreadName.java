package ThreadDemo;


class MyThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running....");
    }
}
public class ThreadName {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread1());

        // getting name of thread
        String name = t1.getName();
        System.out.println("default name of thread by JVM : "+ name);
        System.out.println("Line executed by thread " + Thread.currentThread().getName());

        // setting name of thread
        t1.setName("MyThread1 ");
        String updateName = t1.getName();
        System.out.println("updated name of thread :"+ updateName);

    }
}
