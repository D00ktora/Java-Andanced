/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 18:40
 */
package P12_09CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.contains("End")) {
            String type = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            double special = Double.parseDouble(input.split("\\s+")[2]);

            switch (type) {
                case "Siamese" :
                    Siamese siamese = new Siamese(name, special, type);
                    cats.add(siamese);
                    break;
                case "Cymric" :
                    Cymric cymric = new Cymric(name, special, type);
                    cats.add(cymric);
                    break;
                case "StreetExtraordinaire" :
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, special, type);
                    cats.add(streetExtraordinaire);
                    break;
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(input)) {
                System.out.println(cat.toString());
            }
        }
    }
}
