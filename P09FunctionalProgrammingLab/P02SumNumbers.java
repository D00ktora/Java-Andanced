/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 9:13
 */
package P09FunctionalProgrammingLab;

import java.util.Scanner;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        if (input.length < 2) {
            System.out.println("Count = " + input.length);
            System.out.println("Sum = " + input[0]);
        } else {
            Function<String, Integer> parser = x -> Integer.parseInt(x);
            int sum = 0;
            for (String s : input) {
                int temp = parser.apply(s);
                sum += temp;
            }
            System.out.println("Count = " + input.length);
            System.out.println("Sum = " + sum);
        }
    }
}
