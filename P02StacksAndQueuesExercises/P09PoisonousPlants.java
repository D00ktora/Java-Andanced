/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 7:53
 */
package P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> flowers = new ArrayDeque<>();
        int numberOfFlowers = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfFlowers; i++) {
            flowers.push(scanner.nextInt());
        }
        int days = 0;
        while (true) {
            ArrayDeque<Integer> temp = new ArrayDeque<>();
            int counter = 0;
            int flowersSize = flowers.size();
            for (int i = 0; i < flowersSize - 1; i++) {
                int flower = flowers.pop();
                if (flower <= flowers.peek()) {
                    temp.push(flower);
                } else {
                    counter++;
                }
            }
            int flower = flowers.pop();
            temp.push(flower);
            for (Integer integer : temp) {
                flowers.push(integer);
            }
            if (counter > 0) {
                days++;
            } else {
                break;
            }
        }
        System.out.println(days);
    }
}
