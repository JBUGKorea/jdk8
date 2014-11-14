package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 12
 * Time: 오후 4:05
 * To change this template use File | Settings | File Templates.
 */
public class NaturalNumber<T extends Integer> {
    private T n;

    public NaturalNumber(T n)  { this.n = n; }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }
}
