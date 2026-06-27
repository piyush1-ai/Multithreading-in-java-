package ThreadDemo;

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread running - " + Thread.currentThread().getName());
        }
    }
}
public class FirstProg {
    public static void main(String[] args) {
        System.out.println("Hello");
        MyThread t = new MyThread(); // instantiation of thread
        MyThread t2 = new MyThread();
//        t.run(); // starting of thread
        t.start(); // create a new thread
        t2.start();
        /*
        thread schedular:
        when multiple threads are waiting for execution, the determination of which
        thread will be executed first is made by " Thread schedular" an internal component of JVM
        the specific algo or behaviour is not fixed and vary JVM to JVM.

        Most Important:
        Start() vs run()
        --> when we do t.start() a new thread is created and this new thread is responsible
                for executing run() method.
         ---> when we do run() no new thread will be created , the run () is executed by main thread only

         =========================================================================================================
         importance of start()
         1. Register thread with Thread Scheduler
         2.low level activities
         3.Invoking run()



         */
        for (int i = 0; i < 5; i++) {
            System.out.println("main thread...");
        }
    }
}

