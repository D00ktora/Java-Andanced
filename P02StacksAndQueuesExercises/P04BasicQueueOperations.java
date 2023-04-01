/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 2.3.2023 г.
 * Time: 19:26
 */
package P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfItems = scanner.nextInt();
        int numberOfElementsToRemove = scanner.nextInt();
        int elementToCheck = scanner.nextInt();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfItems; i++) {
            numbers.offer(scanner.nextInt());
        }

        for (int i = 0; i < numberOfElementsToRemove; i++) {
            numbers.poll();
        }

        if (numbers.size() < 1) {
            System.out.println(0);
            return;
        }

        if (numbers.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbers));
        }
    }
}
