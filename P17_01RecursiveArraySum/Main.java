/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.3.2023 г.
 * Time: 5:09
 */
package P17_01RecursiveArraySum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt( i -> Integer.parseInt(i))
                .toArray();

        int currIndex = ints.length - 1;

        int sum = sumRecursive(ints, currIndex);
        System.out.println(sum);
    }

    private static int sumRecursive(int[] ints, int currIndex) {

        if (currIndex == 0) {
            return ints[currIndex];
        }

        return ints[currIndex] + sumRecursive(ints, currIndex - 1);
    }
}
