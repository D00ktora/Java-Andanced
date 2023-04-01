/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 17:14
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> collection = new LinkedHashSet<>();
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String name = scanner.nextLine();
            collection.add(name);
        }

        for (String name : collection) {
            System.out.println(name);
        }
    }
}
