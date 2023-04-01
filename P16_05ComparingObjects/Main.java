/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 8:04
 */
package P16_05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int same = 0;
        int different = 0;
        int total = 0;

        String input = scanner.nextLine();

        while (!input.contains("END")) {
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            String town = input.split(" ")[2];

            Person person = new Person(name, age, town);
            personList.add(person);
            input = scanner.nextLine();
        }

        int indexOfPerson = Integer.parseInt(scanner.nextLine());
        Person serachedPerson = personList.get(indexOfPerson - 1);

        for (Person person : personList) {
            if (serachedPerson.compareTo(person) == 0) {
                same++;
            } else {
                different++;
            }
        }
        if (same == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", same, different, personList.size());
        }
    }

}
