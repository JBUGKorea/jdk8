package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 12
 * Time: 오후 4:03
 * To change this template use File | Settings | File Templates.
 */
public class BoundedTypeTest {
    static void test1(){
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        //integerBox.inspect("some text"); // error: this is still String!

    }

    public static void main(String[] args) {
        test1();
    }
}
