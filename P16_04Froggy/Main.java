/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 7:39
 */
package P16_04Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(input);
        String junk = scanner.nextLine();

        List<String> forPrint = new ArrayList<>();
        for (Integer integer : lake) {
            forPrint.add(String.valueOf(integer));
        }

        System.out.println(String.join(", ", forPrint));
    }
}
