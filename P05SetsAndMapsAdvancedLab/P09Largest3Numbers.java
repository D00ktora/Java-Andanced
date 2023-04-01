/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:26
 */
package P05SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(list);
        Collections.reverse(list);
        if (list.size() > 3) {
            for (int i = 0; i < 3; i++) {
                System.out.print(list.get(i) + " ");
            }
        } else {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }
}
