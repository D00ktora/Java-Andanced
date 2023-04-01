/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 22.2.2023 г.
 * Time: 6:07
 */
package P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int first = Integer.valueOf(stack.pop());
            String op = stack.pop();
            int second = Integer.valueOf(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }

        }
        System.out.println(stack.pop());


    }
}
