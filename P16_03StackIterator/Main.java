/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 7:04
 */
package P16_03StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();
        Stack stack = new Stack();

        while (!commands.contains("END")) {

            if (commands.split(" ")[0].contains("Push")) {
                String replace = commands.replace(",", "");
                String[] split = replace.split(" ");
                int[] ints = new int[split.length - 1];

                for (int i = 1; i < split.length; i++) {
                    ints[i - 1] = Integer.parseInt(split[i]);
                }
                stack.push(ints);
            } else if (commands.split(" ")[0].contains("Pop")) {
                int number = stack.pop();
            }
            commands = scanner.nextLine();
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
