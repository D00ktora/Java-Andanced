/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 16:14
 */
package P10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[], Integer> minNumber = x -> {
            int min = x[0];
            for (Integer integer : x) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        };

        String[] input = scanner.nextLine().split("\\s+");
        int[] ints = new int[input.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(input[i]);
        }

        int min = minNumber.apply(ints);
        System.out.println(min);

    }
}
