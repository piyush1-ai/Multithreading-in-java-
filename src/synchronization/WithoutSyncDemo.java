package synchronization;

class BankAccount {
    int bal = 10000;

    public void withdraw(int amount) {
        if (bal >= amount) {
            System.out.println();
            System.out.println(Thread.currentThread().getName() + " is going to withdraw Rs " + amount +" Total bal : " + bal);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }

            bal = bal - amount; // critical section
            System.out.println(Thread.currentThread().getName()+" completed withdraw : Remaining bal = Rs. "+bal);
        }
        else System.out.println("Not enough balance for "+Thread.currentThread().getName());
    }
}

class Person extends Thread{
    BankAccount1 account;
    Person(String name , BankAccount1 account){
        super(name);
        this.account = account;
    }
    @Override
    public void run() {
        account.withdraw(5000);
    }
}

public class WithoutSyncDemo {
    public static void main(String[] args) {
        BankAccount1 account = new BankAccount1();
        Person husband = new Person("Pati",account); // t1
        Person wife = new Person("patni" , account); // t2

        husband.start();
        wife.start();
    }

}
