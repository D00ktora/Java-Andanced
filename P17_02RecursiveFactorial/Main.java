/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.3.2023 г.
 * Time: 5:18
 */
package P17_02RecursiveFactorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int fibunachi = fibun(number);
        System.out.println(fibunachi);
    }

    private static int fibun(int number) {

        if (number == 1) {
            return 1;
        }

        return number * fibun(number - 1);
    }
}
