/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 2.3.2023 г.
 * Time: 5:56
 */
package P01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> historyQueue = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.contains("Home")) {
            if (input.contains("forward")){
                if (!forwardStack.isEmpty()) {
                    String url = forwardStack.pop();
                    System.out.println(url);
                    historyQueue.push(url);
                } else if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                }
            } else if (input.contains("back")) {
                if (historyQueue.size() > 1) {
                    String url = historyQueue.pop();
                    System.out.println(historyQueue.peek());
                    forwardStack.push(url);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                historyQueue.push(input);
                System.out.println(input);
                forwardStack.clear();
            }
            input = scanner.nextLine();
        }
    }
}
