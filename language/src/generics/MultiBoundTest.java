package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 12
 * Time: 오후 4:08
 * To change this template use File | Settings | File Templates.
 */
public class MultiBoundTest {
    class A{

    }
    interface B{

    }
    interface C{

    }

    class D <T extends A & B & C>{

    }

    // 컴파일 에러
//    class E <T extends B & A & C>{
//
//    }
}
