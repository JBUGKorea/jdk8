package test;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 4. 23.
 * Time: 오후 9:37
 * To change this template use File | Settings | File Templates.
 */
public class LabelTest {
    public static void main(String[] args) {
        String searchMe = "Look substring in";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() -
                substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            System.out.println("1111111");
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    System.out.println("22222222");
                    continue test;
                }
            }
            foundIt = true;
            System.out.println("3333333");
            break test;
        }
        System.out.println("4444444444");

        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }
}
