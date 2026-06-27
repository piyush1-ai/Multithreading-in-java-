package prevent;

class Computer extends Thread{
    public Computer(String name){
        super(name);
    }

    // interview : yield() is only hint to schedular and does not guarantee execution switch
    @Override
    public void run() {
        for (int i = 0; i <= 5 ; i++) {
            System.out.println(getName()+" using computer " +i);
            // willing to give chance to other thread
            Thread.yield();
        }
    }
}
public class YieldDemo {
    public static void main(String[] args) {
        Computer c1 = new Computer("F-1");
        Computer c2 = new Computer("F-2");
        c1.start();
        c2.start();

//=============================================================================
        /*
        Life cycle of thread:
        new/born ---> c21.start()====> Ready ---->if TS allocate CPU====>Running--->if run() method completed ===> Dead

         */
    }
}
