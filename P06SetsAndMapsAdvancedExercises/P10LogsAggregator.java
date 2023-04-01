/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 6.3.2023 г.
 * Time: 4:33
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10LogsAggregator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new LinkedHashMap<>();
        int iterations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < iterations; i++) {
            String input = scanner.nextLine();
            String ip = input.split("\\s+")[0];
            String user = input.split("\\s+")[1];
            int durations = Integer.parseInt(input.split("\\s+")[2]);

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>());
            }
            if (!users.get(user).containsKey(ip)) {
                users.get(user).put(ip, durations);
            } else {
                users.get(user).put(ip, users.get(user).get(ip) + durations);
            }
        }

        users.entrySet()
                .stream()
                .sorted((u1, u2) -> u1.getKey().compareTo(u2.getKey()))
                .forEach(u -> {
                    int totalDuration = u.getValue()
                            .values()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum();

                    String[] ips = u.getValue()
                            .keySet()
                            .stream()
                            .sorted()
                            .toArray(String[]::new);

                    System.out.printf("%s: %d [%s]%n",
                            u.getKey(), totalDuration, String.join(", ", ips));
                });
    }
}
