package synchronization;
/*
        Synchronization notes:
        1.synchronized keyword is applicable for methods and block only
        2.Internally synchronization concept is implemented using locks
        3.Each object in java has unique lock. The usage of synchronized is
        keyword activates the block concept
        4. If thread wants to execute synchronization method on a given object , it must first
        acquire lock on that object ,one thread get lock on the object it permitted to execute synchronization method
        5. When synchronization method execution is completed the thread automatically release the lock


 */

class BankAccount1 {
    int bal = 10000;

     public void  withdraw(int amount) {
         synchronized(this) {
             if (bal >= amount) {
                 System.out.println();
                 System.out.println(Thread.currentThread().getName() + " is going to withdraw Rs " + amount + " Total bal : " + bal);
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {

                 }

                 if (bal >= amount)
                     bal = bal - amount;// critical section

                 System.out.println(Thread.currentThread().getName() + " completed withdraw : Remaining bal = Rs. " + bal);

             } else System.out.println("Not enough balance for " + Thread.currentThread().getName());
         }
        }
    }


class Person1 extends Thread {
    BankAccount1 account;

    Person1(String name, BankAccount1 account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(5000);
    }
}

public class WithSyncDemo {
    public static void main(String[] args) {
        BankAccount1 account = new BankAccount1();
        Person1 husband = new Person1("Pati", account); // t1
        Person1 wife = new Person1("patni", account); // t2
        Person1 child = new Person1("child", account); // t3

        husband.start();
        wife.start();
        child.start();
    }

}

