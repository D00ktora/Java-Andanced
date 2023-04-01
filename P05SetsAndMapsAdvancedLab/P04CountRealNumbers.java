/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:25
 */
package P05SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> appearances = new LinkedHashMap<>();
        String[] inputArr = scanner.nextLine().split("\\s+");
        Double[] doubles = new Double[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            doubles[i] = Double.parseDouble(inputArr[i]);
        }

        for (Double aDouble : doubles) {
            if (appearances.containsKey(aDouble)) {
                Integer integer = appearances.get(aDouble);
                integer++;
                appearances.put(aDouble, integer);
            } else {
                appearances.put(aDouble, 1);
            }
        }

        for (Double aDouble : appearances.keySet()) {
            System.out.printf("%.1f -> %d%n",aDouble, appearances.get(aDouble));
        }
    }
}
