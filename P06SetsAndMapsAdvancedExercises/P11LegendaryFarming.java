/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 6.3.2023 г.
 * Time: 4:56
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> items = new LinkedHashMap<>();
        items.put("fragments", 0);
        items.put("shards", 0);
        items.put("motes", 0);

        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();

        String winner = "";

        while (winner.equals("")) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length - 1; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String item = tokens[i + 1].toLowerCase();

                if (!items.containsKey(item)) {
                    if (junk.containsKey(item)) {
                        junk.put(item, junk.get(item) + quantity);
                    } else {
                        junk.put(item, quantity);
                    }
                } else {
                    items.put(item, items.get(item) + quantity);

                    if (items.get(item) >= 250) {
                        if (item.equals("shards")) {
                            winner = "Shadowmourne";
                        } else if (item.equals("fragments")) {
                            winner = "Valanyr";
                        } else {
                            winner = "Dragonwrath";
                        }

                        items.put(item, items.get(item) - 250);

                        break;
                    }
                }
            }
        }

        System.out.printf("%s obtained!%n", winner);

        items.entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    int result = Integer.compare(i2.getValue(), i1.getValue());

                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }

                    return result;
                })
                .forEach(i -> {
                    System.out.printf("%s: %d%n", i.getKey(), i.getValue());
                });

        junk.entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
                .forEach(i -> {
                    System.out.printf("%s: %d%n", i.getKey(), i.getValue());
                });
    }
}
