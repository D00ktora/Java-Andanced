/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 6:39
 */
package P11Car_Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String carInfo = scanner.nextLine();
            String name = carInfo.split("\\s+")[0];
            String model = carInfo.split("\\s+")[1];
            int horsePower = Integer.parseInt(carInfo.split("\\s+")[2]);

            Car currentCar = new Car(name, model, horsePower);

            carList.add(currentCar);
        }

        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }
}
