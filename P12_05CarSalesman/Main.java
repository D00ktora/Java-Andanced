/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 16:24
 */
package P12_05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Engine engine = null;
            if (input.length == 2) {
                engine = new Engine(input[0], input[1]);
            } else if (input.length == 3) {
                String type = "";
                if (input[2].charAt(0) >= '0' && input[2].charAt(0) <= '9') {
                    type = "Displacement";
                } else {
                    type = "Efficiency";
                }

                if (type == "Displacement") {
                    engine = new Engine(input[0], input[1], input[2]);
                } else {
                    engine = new Engine(input[0], input[1], "n/a", input[2]);
                }
            } else if (input.length == 4) {
                engine = new Engine(input[0], input[1], input[2], input[3]);
            }
            engines.add(engine);
        }
        
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = null;

            if (input.length == 2){
                Engine engine = null;
                for (Engine enginee : engines) {
                    if (enginee.getModel().equals(input[1])) {
                        engine = enginee;
                    }
                }
                car = new Car(input[0], engine);
            } else if (input.length == 3) {
                Engine engine = null;
                for (Engine enginee : engines) {
                    if (enginee.getModel().equals(input[1])) {
                        engine = enginee;
                    }
                }

                String type = "";
                if (input[2].charAt(0) >= '0' && input[2].charAt(0) <= '9') {
                    type = "weight";
                } else {
                    type = "color";
                }

                if (type == "weight") {
                    car = new Car(input[0], engine, input[2]);
                } else {
                    car = new Car(input[0], engine, "n/a", input[2]);
                }
            } else if (input.length == 4) {
                Engine engine = null;
                for (Engine enginee : engines) {
                    if (enginee.getModel().equals(input[1])) {
                        engine = enginee;
                    }
                }
                car = new Car(input[0], engine, input[2], input[3]);
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
