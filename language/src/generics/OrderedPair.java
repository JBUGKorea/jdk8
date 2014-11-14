package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 9
 * Time: 오후 12:37
 * To change this template use File | Settings | File Templates.
 */
public class OrderedPair<K, V> extends Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        super(key, value);
        this.key = key;
        this.value = value;
    }

    public K getKey()   { return key; }
    public V getValue() { return value; }

    public void setKey(K key)   { this.key = key; }
    public void setValue(V value) { this.value = value; }
}
