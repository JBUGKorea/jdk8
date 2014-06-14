package generics;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14. 5. 12
 * Time: 오후 5:19
 * To change this template use File | Settings | File Templates.
 */
public class BoxDemo {

    public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
        // U타입의 박스를 생선한다.
        Box<U> box = new Box<>();
        // 파라미터로 받은 U타입의 컨텐츠를 저장한다.
        box.set(u);
        // 만들어진 U 타입의 박스를 두번째 파라미터로 받은 U타입의 박스 목록에 추가한다.
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        // U타입의 박스 목록 갯수만큼 반복하면서
        for (Box<U> box: boxes) {
            // 박스에서 U 타입의 컨텐츠를 받아온다.
            U boxContents = box.get();
            // 카운터를 출력하고, U 타입의 컨텐츠의 내용을 출력한다.
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        // Integer의 박스를 담는 ArrayList를 생성한다.
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
                new java.util.ArrayList<>();
        // Integer 타입의 컨텐츠(10)와 생성해둔 Integer의 박스를 담는 ArrayList 객체를 보낸다.
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        // Integer 타입의 컨텐츠(20)와 생성해둔 Integer의 박스를 담는 ArrayList 객체를 보낸다.
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        // Integer 타입의 컨텐츠(30)와 생성해둔 Integer의 박스를 담는 ArrayList 객체를 보낸다.
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        // 세 개의 Integer의 박스를 담은 ArrayList 객체를 보낸다.
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }
}