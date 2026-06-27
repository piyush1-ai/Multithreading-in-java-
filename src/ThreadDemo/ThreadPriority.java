package ThreadDemo;

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i++){
            System.out.println("Thread is running...."+Thread.currentThread().getName());
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread2(),"Thread -1");
        Thread t2 = new Thread(new MyThread2(),"Thread -2");

        // set priority
        t1.setPriority(Thread.MIN_PRIORITY);//1
        t2.setPriority(Thread.MAX_PRIORITY);//10

        t1.start();
        t2.start();

        /*

        Thread priorities :
        In java priorities can from 1 to 10 where 1 is the lowest priority and 10 is
        the highest priority . The default priority of thread is inherited from its parent thread(main) is 5

        ---> It is not thumb rule that if we set priority then threads runs on priority
                it completely depends on jvm

        Thread.MIN_PRIORITY -->1
        Thread.MAX_PRIORITY --->10
        Thread.NORM_PRIORITY -->5

         */
    }
}

