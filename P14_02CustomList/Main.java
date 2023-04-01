/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 7:04
 */
package P14_02CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        CustomList<String> customList = new CustomList<>();

        while (!command.contains("END")) {
            switch (command.split(" ")[0]) {
                case "Add":
                    customList.add(command.split(" ")[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "Contains":
                    boolean contains = customList.contains(command.split(" ")[1]);
                    System.out.println(contains);
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(command.split(" ")[1]), Integer.parseInt(command.split(" ")[2]));
                    break;
                case "Greater":
                    int count = customList.countGreaterThan(command.split(" ")[1]);
                    System.out.println(count);
                    break;
                case "Max":
                    String max = customList.getMax();
                    System.out.println(max);
                    break;
                case "Min":
                    String min = customList.getMin();
                    System.out.println(min);
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    Sorter.sort(customList);
            }
            command = scanner.nextLine();
        }
    }
}
