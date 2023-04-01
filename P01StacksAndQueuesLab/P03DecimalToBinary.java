/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 22.2.2023 г.
 * Time: 6:18
 */
package P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0 ) {
            System.out.println(0);
            return;
        }
        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
