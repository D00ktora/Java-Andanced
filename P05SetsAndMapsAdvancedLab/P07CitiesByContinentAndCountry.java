/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:25
 */
package P05SetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            if (continents.containsKey(continent)) {
                Map<String, List<String>> continentMap = continents.get(continent);
                if (continentMap.containsKey(country)) {
                    List<String> tempList = continentMap.get(country);
                    tempList.add(city);
                    continentMap.put(country, tempList);
                    continents.put(continent, continentMap);
                } else {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(city);
                    continentMap.put(country, tempList);
                    continents.put(continent, continentMap);
                }
            } else {
                Map<String, List<String>> continentMap = new LinkedHashMap<>();
                List<String> tempList = new ArrayList<>();
                tempList.add(city);
                continentMap.put(country, tempList);
                continents.put(continent, continentMap);
            }
        }

        for (String continent : continents.keySet()) {
            System.out.printf("%s:%n",continent);
            Map<String, List<String>> continentMap = continents.get(continent);
            for (String country : continentMap.keySet()) {
                System.out.printf("  %s -> ",country);
                List<String> citys = continentMap.get(country);
                System.out.println(String.join(", ", citys));
            }
        }
    }
}
