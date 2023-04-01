/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 9:36
 */
package P09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> doubles = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble)
                .map(numer -> numer * 1.2).collect(Collectors.toList());
        System.out.print("Prices with VAT:");
        for (Double aDouble : doubles) {
            System.out.print(System.lineSeparator());
            System.out.printf("%.2f", aDouble);
        }
    }
}
