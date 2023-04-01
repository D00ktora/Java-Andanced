package P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.2.2023 г.
 * Time: 18:34
 */

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String current = "";

        while (!input.contains("Home")) {
            if (input.contains("back")) {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    stack.push(current);
                }
                current = input;
            }
            System.out.println(current);
            input = scanner.nextLine();
        }
    }
}
