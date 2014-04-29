package ramda;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 4. 30.
 * Time: 오전 1:25
 * To change this template use File | Settings | File Templates.
 */
public class TargetType {

    public static void main(String[] args) {
        String s = invoke(() -> "done");
    }

    public interface Runnable {
        void run();
    }

    public interface Callable<V> {
        V call();
    }

    static void invoke(Runnable r) {
        r.run();
    }

    static <T> T invoke(Callable<T> c) {
        return c.call();
    }
}
