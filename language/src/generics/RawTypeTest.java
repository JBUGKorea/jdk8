package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 9
 * Time: 오후 12:41
 * To change this template use File | Settings | File Templates.
 */
public class RawTypeTest {
    static void test1(){
        Box rawBox = new Box();
        System.out.println(rawBox.get());
    }
    static void test2(){
        Box<String> stringBox = new Box<>();
        Box rawBox = stringBox;               // OK
        System.out.println(rawBox.get());
    }
    static void test3(){
        Box rawBox = new Box();           // rawBox is a raw type of Box<T>
        Box<Integer> intBox = rawBox;     // warning: unchecked conversion
        System.out.println(intBox.get());
    }
    static void test4(){
        Box<String> stringBox = new Box<>();
        Box rawBox = stringBox;
        rawBox.set(8);  // warning: unchecked invocation to set(T)
        System.out.println(rawBox.get());
    }

    static void test5(){
        Box<Integer> bi;
        bi = createBox();
        System.out.println(bi.get());
    }

    //@SuppressWarnings("unchecked")
    static void test6(){
        Box<Integer> bi;
        bi = createBox();
        System.out.println(bi.get());
    }

    static Box createBox(){
        System.out.println("기존 코드");
        return new Box();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
