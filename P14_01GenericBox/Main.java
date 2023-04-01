/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 20:42
 */
package P14_01GenericBox;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();
        for (int i = 0; i < numberOfInputs; i++) {
            Double input = Double.parseDouble(scanner.nextLine());
            box.getTypes().add(input);
        }
        double text = Double.parseDouble(scanner.nextLine());

        System.out.println(box.getMaxElement(text));

       // System.out.println(box.toString());
    }
}
