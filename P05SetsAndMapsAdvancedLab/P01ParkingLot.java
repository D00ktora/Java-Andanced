/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:24
 */
package P05SetsAndMapsAdvancedLab;

import java.util.*;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> carList = new LinkedHashSet<>();

        while (!input.contains("END")) {
            String[] inputArr = input.split(", ");
            String command = inputArr[0];
            String car = inputArr[1];
            if (command.equals("IN")) {
                carList.add(car);
            } else if (command.equals("OUT")) {
                carList.remove(car);
            }
            input = scanner.nextLine();
        }

        if (carList.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }
        for (String car : carList) {
            System.out.println(car);
        }
    }
}
