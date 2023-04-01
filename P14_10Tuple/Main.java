/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 8:37
 */
package P14_10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String names = input.split(" ")[0] + " " + input.split(" ")[1];
        String address = input.split(" ")[2];
        String town = input.split(" ")[3];
        Tuple<String, String, String> tuple1 = new Tuple<>(names, address, town);
        System.out.println(tuple1);

        input = scanner.nextLine();
        String name = input.split(" ")[0];
        int littersOfBeer = Integer.parseInt(input.split(" ")[1]);
        boolean drunk;

        if (input.split(" ")[2].equals("drunk")) {
            drunk = true;
        } else {
            drunk = false;
        }

        Tuple<String, Integer, Boolean> tuple2 = new Tuple<>(name, littersOfBeer, drunk);
        System.out.println(tuple2);

        input = scanner.nextLine();
        name = input.split(" ")[0];
        double doubller = Double.parseDouble(input.split(" ")[1]);
        String bankName = input.split(" ")[2];

        Tuple<String, Double, String> tuple3 = new Tuple<>(name, doubller, bankName);
        System.out.println(tuple3);

    }
}
