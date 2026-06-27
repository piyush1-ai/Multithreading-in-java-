package Java8;
// functional interface
@FunctionalInterface
interface Calculator{
    public int operation(int a , int b); // one abstract method
}
interface Print{
    void display(String s);
}
public class FunctionalDemo  {
    public static void main(String[] args) {
        System.out.println("Hello");
        // lambda expression --> function without name
        Calculator c1 = (a,b)->{return a+b;};
        int res = c1.operation(10,20);
        System.out.println(res);
        Print p1 = (name -> System.out.println(name));
        Print p2 = (System.out::println);
        p1.display("piyush");
        p2.display("Son");
    }
}
