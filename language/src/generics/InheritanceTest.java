package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 12
 * Time: 오후 4:55
 * To change this template use File | Settings | File Templates.
 */
public class InheritanceTest {
    static void test1(){
        Box<Number> box = new Box<Number>();
        box.set(new Integer(10));
        box.set(new Double(10.1));
    }
    public static void main(String[] args) {
        test1();
    }
}
