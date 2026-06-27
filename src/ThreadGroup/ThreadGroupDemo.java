package ThreadGroup;
/*
 interview :ThreadGroup is mostly used for monitoring and bulk control,
 but in modern java dev prefer ExecutorService instead of ThreadGroup
 */

class  Mythread extends  Thread{
    Mythread(ThreadGroup group , String name){
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("Thread name : " + Thread.currentThread().getName()+
                "Group : " + Thread.currentThread().getThreadGroup().getName());
    }
}
public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup apiGroup = new ThreadGroup("API-group");
        Mythread t1 = new Mythread(apiGroup,"API-Thread-1");
        Mythread t2 = new Mythread(apiGroup,"API-Thread-2");
        t1.start();
        t2.start();
    }
}
