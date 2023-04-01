/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 9:31
 */
package P12_04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCarsToAdd = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCarsToAdd; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tirePressure1 = Double.parseDouble(input[5]);
            int tireAge1 = Integer.parseInt(input[6]);
            double tirePressure2 = Double.parseDouble(input[7]);
            int tireAge2 = Integer.parseInt(input[8]);
            double tirePressure3 = Double.parseDouble(input[9]);
            int tireAge3 = Integer.parseInt(input[10]);
            double tirePressure4 = Double.parseDouble(input[11]);
            int tireAge4 = Integer.parseInt(input[12]);

            Car temp = new Car(
                    model,
                    speed,
                    power,
                    cargoWeight,
                    cargoType,
                    tirePressure1,
                    tireAge1,
                    tirePressure2,
                    tireAge2,
                    tirePressure3,
                    tireAge3,
                    tirePressure4,
                    tireAge4);

            carList.add(temp);
        }

        String command = scanner.nextLine();

        if (command.contains("fragile")) {
            List<Car> fragile = carList.stream()
                    .filter(car -> car.getCargo().getType().equals("fragile") &&
                            (car.getTires().getTirePressure1() < 1 || car.getTires().getTirePressure2() < 1 ||
                            car.getTires().getTirePressure3() < 1 || car.getTires().getTirePressure4() < 1))
                    .collect(Collectors.toList());
            for (Car car : fragile) {
                System.out.println(car.toString());
            }
        } else if (command.contains("flamable")) {
            List<Car> flamable = carList.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250)
                    .collect(Collectors.toList());
            for (Car car : flamable) {
                System.out.println(car.toString());
            }
        }


    }
}
