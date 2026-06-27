package Communication;

/*
     ***Inter thread communication*****

            1.wait(): called on a object with synchronized context to make the current thread wait until
    another thread invoke() or invokeAll()

    when thread call wait(),it release the lock on the object and enter
    into waiting state until it receive a notification

        2. notify(): method is called on object with synchronized context to wake up a single thread that is waiting on
    the same object.when notify invokes it notify one of the thread that are waiting on the object
    to wake up.
    The choice of which thread to notify is not specified and depends on the jvm, implementation

        3.notifyALl(): when notifyAll() is called all thread that are waiting on the eligible
    to wake up , but which thread actually get the lock first determined by thread schedular
*/

class WeddingHall {
    boolean dinnerReddy = false;
}

class Guest extends Thread {
    WeddingHall hall;

    Guest(WeddingHall h) {
        hall = h;
    }

    @Override
    public void run() {
        synchronized (hall) {
            System.out.println("Guest enter in the hall...");
            while (!hall.dinnerReddy) {
                System.out.println("Dinner not ready. Guest please wait...");
                try {
                    hall.wait();
                    System.out.println("getting lock back...");// release lock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Guest is having dinner....");
        }
    }
}

class Chef extends Thread {
    WeddingHall hall;

    Chef(WeddingHall h) {
        hall = h;
    }

    @Override
    public void run() {
        synchronized (hall) {
            System.out.println("chef started preparing dinner....");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
            hall.dinnerReddy = true;
            System.out.println("Chef :Dinner is ready");
            hall.notify();
        }
    }
}

public class WaitDemo {
    public static void main(String[] args) {
        WeddingHall hall = new WeddingHall();
        Guest guest = new Guest(hall);
        Chef chef = new Chef(hall);

        guest.start();
        chef.start();
    }
}
