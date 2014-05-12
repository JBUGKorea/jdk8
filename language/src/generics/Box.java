package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 9
 * Time: 오후 12:33
 * To change this template use File | Settings | File Templates.
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}