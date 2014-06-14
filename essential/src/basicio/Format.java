package basicio;

/**
 * Created by 예규 on 2014-06-14.
 */
public class Format {
    public static void main(String[] args) {
        System.out.format("%f%f, %2$+020.10f %n", -Math.PI,Math.PI);
    }
}
