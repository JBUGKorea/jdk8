package generics;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 12
 * Time: 오후 5:14
 * To change this template use File | Settings | File Templates.
 */
interface PayloadList<E,P> extends List<E> {
    void setPayload(int index, P val);
}
