/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 9:24
 */
package P09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = str -> str.charAt(0) >= 'A' && str.charAt(0) <= 'Z';

        List<String> collect = Arrays.stream(input).filter(predicate).collect(Collectors.toList());

        System.out.println(collect.size());
        for (String word : collect) {
            System.out.println(word);
        }
    }
}
