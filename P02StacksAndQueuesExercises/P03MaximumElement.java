/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 2.3.2023 г.
 * Time: 19:21
 */
package P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int numberOfComands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfComands; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    int number = scanner.nextInt();
                    numbers.push(number);
                    break;
                case 2:
                    numbers.pop();
                    break;
                case 3:
                    if (numbers.size() > 0) {
                        System.out.println(Collections.max(numbers));
                    }
                    break;
            }
        }
    }
}
