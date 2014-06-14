package jenerics;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 5. 8.
 * Time: 오후 8:19
 * To change this template use File | Settings | File Templates.
 */
public class Test1 {
    private Object o;
    void set(Object o){
        this.o = o;
    }
    Object get(){
        return o;
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        // String을 set 하고
        t.set(new String("10"));
        // Integer로 받으려고 하면 <-- 바보 (런타임 에러 나지롱~)
        Integer i = (Integer)t.get();
    }
}
