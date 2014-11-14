package lambda;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 4. 30.
 * Time: 오전 12:10
 * To change this template use File | Settings | File Templates.
 */
public class Approach1 {

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }

        //java.util.Arrays.sort();
    }
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        printPersonsOlderThan(roster, 10);
    }
}
