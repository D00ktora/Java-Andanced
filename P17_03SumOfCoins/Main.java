package P17_03SumOfCoins;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> integerList = new ArrayList<>();

        for (int coin : coins) {
            integerList.add(coin);
        }

        Collections.sort(integerList);
        Collections.reverse(integerList);
        int index = 0;
        while (targetSum >= integerList.get(integerList.size() - 1)) {



            if (targetSum - integerList.get(index) >= 0) {
                map.putIfAbsent(integerList.get(index), 0);
                targetSum -= integerList.get(index);
                map.put(integerList.get(index), map.get(integerList.get(index)) + 1);
            } else {
                index++;

            }
        }
        if (targetSum != 0) {
            throw new IllegalArgumentException("Error");
        }
        return map;
    }
}