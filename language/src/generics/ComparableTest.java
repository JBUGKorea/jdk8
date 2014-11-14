package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 12
 * Time: 오후 4:14
 * To change this template use File | Settings | File Templates.
 */
public class ComparableTest {
    public static <T extends Comparable<T>> int countGraterThan(T[] anArray, T elem){
        int count=0;
        for (T e:anArray)
            if (e.compareTo(elem)>0)
                ++count;
        return count;
    }
    public static void main(String[] args) {
    }

    class ComparableObject<T extends Integer> implements Comparable<T>{
        public int compareTo(T o){
            return o.intValue();
        }
    }
}
