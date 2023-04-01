/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 9:05
 */
package P12_03SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];
            double fuel = Double.parseDouble(input.split("\\s+")[1]);
            double distancePerKM = Double.parseDouble(input.split("\\s+")[2]);

            carList.add(new Car(model,fuel,distancePerKM));
        }

        String command = scanner.nextLine();

        while (!command.contains("End")) {
            String carModel = command.split("\\s+")[1];
            int amountOfKM = Integer.parseInt(command.split("\\s+")[2]);

            for (Car car : carList) {
                if (car.getModel().equals(carModel)) {
                    if (car.isFuelEnough(amountOfKM)) {
                        double neededFuel = car.getFuelCost() * amountOfKM;
                        car.setFuelAmount(car.getFuelAmount() - neededFuel);
                        car.setTravel(car.getTravel() + amountOfKM);
                        break;
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }
}
