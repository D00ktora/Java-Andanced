/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 8:35
 */
package P16_07EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPpl = Integer.parseInt(scanner.nextLine());
        Set<Person> tree = new TreeSet<>();
        Set<Person> hash = new HashSet<>();

        for (int i = 0; i < numberOfPpl; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            Person person = new Person(name, age);
            tree.add(person);
            hash.add(person);
        }

        System.out.println(tree.size());
        System.out.println(hash.size());
    }
}
