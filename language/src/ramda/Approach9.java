package ramda;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 4. 30.
 * Time: 오전 12:10
 * To change this template use File | Settings | File Templates.
 */
public class Approach9 {

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        roster
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 10
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }

    interface Predicate<Person> {
        boolean test(Person t);
    }
}
