/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.3.2023 г.
 * Time: 5:38
 */
package P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.contains("print")) {
            if (input.contains("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n",queue.poll());
                }
            } else {
                queue.offer(input);
            }
            input = scanner.nextLine();
        }

        for (String s : queue) {
            System.out.println(s);
        }
    }
}
