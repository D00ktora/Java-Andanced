/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 2.3.2023 г.
 * Time: 19:28
 */
package P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P05BalancedParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> characters = new ArrayDeque<>();

        String[] chars = scanner.nextLine().split("");

        for (int i = 0; i < chars.length; i++) {
            String character = chars[i];
            if (character.equals("(") || character.equals("[") || character.equals("{")) {
                characters.push(character);
            } else if (character.equals(")")) {
                String chartAtTop = characters.peek();
                if (characters.size() > 0 && chartAtTop.equals("(")) {
                    characters.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            } else if (character.equals("]")) {
                String chartAtTop = characters.peek();
                if (characters.size() > 0 && chartAtTop.equals("[")) {
                    characters.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            } else if (character.equals("}")) {
                String chartAtTop = characters.peek();
                if (characters.size() > 0 && chartAtTop.equals("{")) {
                    characters.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (characters.size() < 1) {
            System.out.println("YES");
        }
    }
}
