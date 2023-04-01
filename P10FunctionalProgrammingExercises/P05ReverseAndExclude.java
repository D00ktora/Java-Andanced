/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 17:08
 */
package P10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int number = Integer.parseInt(scanner.nextLine());

        integerList = integerList.stream().filter(x -> x % number != 0).collect(Collectors.toList());

        Collections.reverse(integerList);

        integerList.forEach(e -> System.out.printf("%d ", e));

    }
}
