/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 8:15
 */
package P16_06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> byName = new TreeSet<>(new PersonCompareByNameLength());
        Set<Person> byAge = new TreeSet<>(new PersonCompareByAge());

        int numberOfPersons = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPersons; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            Person person = new Person(name, age);
            byName.add(person);
            byAge.add(person);
        }

        for (Person person : byName) {
            System.out.println(person);
        }
        for (Person person : byAge) {
            System.out.println(person);
        }
    }
}
