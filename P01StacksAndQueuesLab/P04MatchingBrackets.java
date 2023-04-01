/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.3.2023 г.
 * Time: 5:28
 */
package P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        ArrayDeque<Integer> brackets = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                brackets.push(i);
            } else if (text.charAt(i) == ')'){
                int closingBracket = brackets.pop();
                System.out.println(text.substring(closingBracket, i + 1));
            }
        }
    }
}
