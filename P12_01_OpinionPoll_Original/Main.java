/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 7:58
 */
package P12_01_OpinionPoll_Original;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPersons = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < numberOfPersons; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            Person curr = new Person(name, age);
            personList.add(curr);
        }

        List<Person> sortedPersons = personList.stream().filter(x -> x.getAge() > 30).sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        for (Person sortedPerson : sortedPersons) {
            System.out.println(sortedPerson.toString());
        }
    }
}
