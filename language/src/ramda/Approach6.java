package ramda;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 4. 30.
 * Time: 오전 12:10
 * To change this template use File | Settings | File Templates.
 */
public class Approach6 {

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        printPersonsWithPredicate(
                roster,
                p ->
                        p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 10
                        && p.getAge() <= 25
        );
    }

    interface Predicate<Person> {
        boolean test(Person t);
    }
}
