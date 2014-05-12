package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 9
 * Time: 오후 12:36
 * To change this template use File | Settings | File Templates.
 */
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}