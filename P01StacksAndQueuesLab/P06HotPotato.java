/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.3.2023 г.
 * Time: 5:43
 */
package P01StacksAndQueuesLab;

import java.util.*;
import java.util.stream.Collectors;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> kids = Arrays.stream(scanner.nextLine().split(" ")).map(String::toString).collect(Collectors.toList());
        int numberOfIterations = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 0; i < kids.size(); i++) {
            if (kids.size() == 1) {
                System.out.printf("Last is %s%n",kids.get(0));
                return;
            }
            counter++;
            String kid = kids.get(i);
            if (counter == numberOfIterations) {
                kids.remove(kid);
                System.out.printf("Removed %s%n",kid);
                counter = 0;
                if (i == kids.size()) {
                    i = -1;
                } else {
                    i--;
                }
                continue;
            }
            if (kids.size() == 1) {
                System.out.printf("Last is %s%n",kids.get(0));
                return;
            }
            if (i == kids.size() - 1) {
                i = -1;
            }

        }
    }
}
