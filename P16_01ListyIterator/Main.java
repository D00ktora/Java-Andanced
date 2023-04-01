/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 14:53
 */
package P16_01ListyIterator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator iterator = new ListyIterator();

        String input = scanner.nextLine();

        while (!input.contains("END")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "Create":
                    String[] stringArr = input.split(" ");
                    String[] formated = new String[stringArr.length - 1];
                    for (int i = 1; i < stringArr.length; i++) {
                        formated[i-1] = stringArr[i];
                    }
                    iterator = new ListyIterator(formated);
                    break;
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    try {
                        iterator.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "PrintAll":
                    iterator.printAll();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
