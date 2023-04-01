/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:25
 */
package P05SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Map<String, Double>> shops = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.contains("Revision")) {
            String shop = input.split(",\\s+")[0];
            String item = input.split(",\\s+")[1];
            Double price = Double.parseDouble(input.split(",\\s+")[2]);

            if (shops.containsKey(shop)) {
                Map<String,Double> tempMap = shops.get(shop);
                tempMap.put(item, price);
                shops.put(shop, tempMap);
            } else {
                Map<String, Double> tempMap = new LinkedHashMap<>();
                tempMap.put(item, price);
                shops.put(shop, tempMap);
            }

            input = scanner.nextLine();
        }

        for (String shop : shops.keySet()) {
            System.out.printf("%s->%n",shop);
            Map<String,Double> products = shops.get(shop);
            for (String product : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",product, products.get(product));
            }
        }
    }
}
