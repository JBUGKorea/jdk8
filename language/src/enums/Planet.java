package enums;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 5. 6.
 * Time: 오후 10:33
 * To change this template use File | Settings | File Templates.
 */
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),  // 수성
    VENUS   (4.869e+24, 6.0518e6),  // 금성
    EARTH   (5.976e+24, 6.37814e6), // 지구
    MARS    (6.421e+23, 3.3972e6),  // 화성
    JUPITER (1.9e+27,   7.1492e7),  // 목성
    SATURN  (5.688e+26, 6.0268e7),  // 토성
    URANUS  (8.686e+25, 2.5559e7),  // 천왕성
    NEPTUNE (1.024e+26, 2.4746e7);  // 해왕성

    private final double mass;   // in kilograms 질량
    private final double radius; // in meters 반지름
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2) 만유 인력 상수
    public static final double G = 6.67300E-11;

    // 표면 중력 계산
    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    // 표면 무게 계산
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.err.println("Usage: java Planet <earth_weight>");
//            System.exit(-1);
//        }
        //double earthWeight = Double.parseDouble(args[0]);
        double earthWeight = Double.parseDouble("175");
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}