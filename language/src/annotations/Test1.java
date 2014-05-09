package annotations;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 9
 * Time: 오전 9:23
 * To change this template use File | Settings | File Templates.
 */
public class Test1 {
    /**
     * @deprecated
     * java doc 만들때 사용되는 주석 애노테이션
     */
    @Deprecated
    static void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        test();
    }
}
