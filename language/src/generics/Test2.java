package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 9
 * Time: 오후 12:34
 * To change this template use File | Settings | File Templates.
 */
public class Test2 {
    static void test1(){
        Box<Integer> integerBox = new Box<Integer>();
    }
    static void test2(){
        Box<Integer> integerBox = new Box<>();
    }

    static void test3(){
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
    }

    static void test4(){
        OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        OrderedPair<String, String>  p2 = new OrderedPair<>("hello", "world");
    }

    static void test5(){
        OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
