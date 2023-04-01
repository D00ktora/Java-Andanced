/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.4.2023 г.
 * Time: 16:34
 */
package P20JavaAdvancedExam22October2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> caffeine = new ArrayDeque<>();
        Deque<Integer> energyDrink = new ArrayDeque<>();
        int stamatCoffeine = 0;

        String[] line = scanner.nextLine().split(", ");
        line[line.length - 1] = line[line.length - 1].trim();
        String[] line2 = scanner.nextLine().split(", ");
        line2[line2.length - 1] = line2[line2.length - 1].trim();

        for (String coffe : line) {
            caffeine.push(Integer.parseInt(coffe));
        }
        for (String energy : line2) {
            energyDrink.offer(Integer.parseInt(energy));
        }

        while (!energyDrink.isEmpty() && !caffeine.isEmpty()) {
            int caffe = caffeine.pop();
            int energy = energyDrink.poll();
            int sum = caffe * energy;

            if (stamatCoffeine + sum <= 300) {
                stamatCoffeine += sum;
            } else {
                energyDrink.offer(energy);
                stamatCoffeine -= 30;
                if (stamatCoffeine < 0) {
                    stamatCoffeine = 0;
                }
            }
        }

        if (!energyDrink.isEmpty()) {
            System.out.print("Drinks left: ");
            List<String> collect = energyDrink.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(", ", collect));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamatCoffeine);
    }
}
