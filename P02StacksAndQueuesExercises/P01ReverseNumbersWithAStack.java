/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 2.3.2023 г.
 * Time: 6:22
 */
package P02StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> ints = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (Integer anInt : ints) {
            stack.push(anInt);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
