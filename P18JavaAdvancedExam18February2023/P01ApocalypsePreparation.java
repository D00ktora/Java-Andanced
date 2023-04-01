/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 30.3.2023 г.
 * Time: 18:08
 */
package P18JavaAdvancedExam18February2023;

import java.util.*;
import java.util.stream.Collectors;

public class P01ApocalypsePreparation {
    public static int patch = 30;
    public static int bandage = 40;
    public static int medkit = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> textiles = new ArrayDeque<>();
        Deque<Integer> medicaments = new ArrayDeque<>();

        int[] firstInputRow = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt( i -> Integer.parseInt(i))
                .toArray();
        int[] secondInputRow = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt( i -> Integer.parseInt(i))
                .toArray();
        Map<String, Integer> potion = new LinkedHashMap<>();

        for (int firstInput : firstInputRow) {
            textiles.offer(firstInput);
        }

        for (int secondInput : secondInputRow) {
            medicaments.push(secondInput);
        }

        while (textiles.size() > 0 && medicaments.size() > 0) {
            int textile = textiles.poll();
            int medicament = medicaments.pop();
            int sum = textile + medicament;

            if (sum == patch || sum == bandage || sum == medkit) {
                switch (sum) {
                    case 30:
                        potion.putIfAbsent("Patch", 0);
                        potion.put("Patch", potion.get("Patch") + 1);
                        break;
                    case 40:
                        potion.putIfAbsent("Bandage", 0);
                        potion.put("Bandage", potion.get("Bandage") + 1);
                        break;
                    case 100:
                        potion.putIfAbsent("MedKit", 0);
                        potion.put("MedKit", potion.get("MedKit") + 1);
                        break;
                }
            } else if (sum > medkit) {
                potion.putIfAbsent("MedKit", 0);
                potion.put("MedKit", potion.get("MedKit") + 1);
                sum -= 100;
                int remain = medicaments.pop();
                remain += sum;
                medicaments.push(remain);
            } else {
                medicament += 10;
                medicaments.push(medicament);
            }
        }

        String ended = "";
        if (textiles.size() == 0 && medicaments.size() == 0) {
            ended = "Textiles and medicaments are both empty.";
        } else if (textiles.size() == 0){
            ended = "Textiles are empty.";
        } else if (medicaments.size() == 0) {
            ended = "Medicaments are empty.";
        }

        System.out.println(ended);

        potion.entrySet().stream().sorted((l, r) -> {
            int result = Integer.compare(r.getValue(), l.getValue());
            if (result == 0) {
                result = l.getKey().compareTo(r.getKey());
            }
            return result;
        }).forEach(element -> System.out.println(element.getKey() + " - " + element.getValue()));


        if (ended.equals("Textiles are empty.")) {
            System.out.print("Medicaments left: ");
            List<String> forPrint = new ArrayList<>();
            for (Integer medicament : medicaments) {
                forPrint.add(String.valueOf(medicament));
            }
            System.out.println(String.join(", ", forPrint));
        } else if (ended.equals("Medicaments are empty.")){
            System.out.print("Textiles left: ");
            List<String> forPrint = new ArrayList<>();
            for (Integer textile : textiles) {
                forPrint.add(String.valueOf(textile));
            }
            System.out.println(String.join(", ", forPrint));
        }

    }
}
