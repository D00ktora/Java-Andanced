/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 6.3.2023 г.
 * Time: 4:58
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> concerts = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            Pattern srabskoPattern = Pattern.compile("([\\w\\s]+)\\s@([a-zA-z\\s]+)\\s(\\d+)\\s(\\d+)");
            Matcher srabskoMatcher = srabskoPattern.matcher(input);

            if (srabskoMatcher.find()) {
                String venue = srabskoMatcher.group(2);
                String singer = srabskoMatcher.group(1);
                int ticketPrice = Integer.parseInt(srabskoMatcher.group(3));
                int ticketCount = Integer.parseInt(srabskoMatcher.group(4));


                concerts.putIfAbsent(venue, new LinkedHashMap<>());
                concerts.get(venue).putIfAbsent(singer, 0);

                int earned = ticketCount * ticketPrice;
                int totalEarned = concerts.get(venue).get(singer) + earned;

                concerts.get(venue).put(singer, totalEarned);
            }

            input = scanner.nextLine();
        }

        concerts.forEach((ket, value) -> {
            System.out.println(ket);
            value.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("#  %s -> %s", e.getKey(), e.getValue()));
                    });
        });
    }
}
