package ramda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 4. 30.
 * Time: 오전 12:10
 * To change this template use File | Settings | File Templates.
 */
public class Approach8 {

    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 10
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    interface Predicate<Person> {
        boolean test(Person t);
    }
}
