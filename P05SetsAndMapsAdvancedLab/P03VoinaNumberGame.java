/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 7:25
 */
package P05SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> deckOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> deckTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        int round = 1;
        while (deckOne.size() > 0 && deckTwo.size() >0) {
            round++;
            int cardOne = deckOne.iterator().next();
            int cardTwo = deckTwo.iterator().next();

            deckOne.remove(cardOne);
            deckTwo.remove(cardTwo);

            if (cardOne > cardTwo) {
                deckOne.add(cardOne);
                deckOne.add(cardTwo);
            } else if (cardTwo > cardOne) {
                deckTwo.add(cardOne);
                deckTwo.add(cardTwo);
            }
            if (round >= 50) {
                break;
            }
        }

        if (deckOne.size() > deckTwo.size()) {
            System.out.println("First player win!");
        } else if (deckTwo.size() > deckOne.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
