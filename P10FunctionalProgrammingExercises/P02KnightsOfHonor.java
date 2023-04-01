/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 16:12
 */
package P10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> persons = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        persons.forEach(r -> System.out.println("Sir " + r));
    }
}
