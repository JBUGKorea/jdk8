package ramda;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 4. 30.
 * Time: 오전 12:10
 * To change this template use File | Settings | File Templates.
 */
public class Approach7 {

    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 10
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );
    }

    interface Predicate<Person> {
        boolean test(Person t);
    }
}
