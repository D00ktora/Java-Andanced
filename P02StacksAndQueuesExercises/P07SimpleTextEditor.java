/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 2.3.2023 г.
 * Time: 20:08
 */
package P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> text = new ArrayDeque<>();

        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands; i++) {
            String input = scanner.nextLine();
            int number = Integer.parseInt(input.split(" ")[0]);

            switch (number) {
                case 1: // append
                    String chars = input.split(" ")[1];
                    if (text.size() > 0) {
                        String temp = text.peek();
                        temp += chars;
                        text.push(temp);
                    } else if (text.size() < 1) {
                        text.push(chars);
                    }
                    break;
                case 2:
                    if (text.size() > 0) {
                        int countElements = Integer.parseInt(input.split(" ")[1]);
                        StringBuilder temp = new StringBuilder(text.peek());
                        if (temp.length() >= countElements) {
                            temp.replace(temp.length() - countElements, temp.length(), "");
                            text.push(temp.toString());
                        }
                    }
                    break;
                case 3:
                    if (text.size() > 0) {
                        StringBuilder temp = new StringBuilder(text.peek());
                        int position = Integer.parseInt(input.split(" ")[1]);
                        System.out.println(temp.charAt(position - 1));
                    }
                    break;
                case 4:
                    if (text.size() > 0) {
                        text.pop();
                    }
            }
        }
    }
}
