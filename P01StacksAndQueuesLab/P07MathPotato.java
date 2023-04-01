/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.3.2023 г.
 * Time: 6:31
 */
package P01StacksAndQueuesLab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> childrenQueue = new PriorityQueue<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }

        int cycle = 1;
        while(childrenQueue.size() > 1){
            for (int i = 1; i < numberOfTurns; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + childrenQueue.peek());
            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }
            cycle++;
        }
        String lastChild = childrenQueue.peek();
        System.out.printf("Last is %s%n", lastChild);
    }

    static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i = 2; i < n; i ++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
