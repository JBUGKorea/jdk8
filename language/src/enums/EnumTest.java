package enums;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 5. 6.
 * Time: 오후 10:30
 * To change this template use File | Settings | File Templates.
 */
public class EnumTest {
    Day day;    // 이 변수는 SUNDAY ~ SATURDAY 상수중 하나와 반드시 동일해야 한다.

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();

        // values() 메서드를 사용한 각 상수값 출력하기
        for (Day d:Day.values()){
            System.out.println(d.toString());
        }
    }
}