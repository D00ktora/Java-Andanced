/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 16:29
 */
package P10FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(numer -> numer += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractCommand = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(n -> n *= 2).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));
        while (!input.contains("end")) {
            switch (input) {
                case "add":
                    integerList = add.apply(integerList);
                    break;
                case "multiply":
                    integerList = multiply.apply(integerList);
                    break;
                case "subtract":
                    integerList = subtractCommand.apply(integerList);
                    break;
                case "print":
                    print.accept(integerList);
                    System.out.println();
            }
            input = scanner.nextLine();
        }
    }
}
