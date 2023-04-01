/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.4.2023 г.
 * Time: 7:31
 */
package P19JavaAdvancedRetakeExam14December2022;

import java.util.*;

public class P01ClimbthePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> foodSupply = new ArrayDeque<>();
        Deque<Integer> stamina = new ArrayDeque<>();

        int[] foodArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int f : foodArr) {
            foodSupply.push(f);
        }

        int[] stam = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int s : stam) {
            stamina.offer(s);
        }

        int peeks = 0;
        boolean vihren = false;
        boolean kutelo = false;
        boolean banski = false;
        boolean polezhan = false;
        boolean kamenitza = false;
        List<String> conquered = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (peeks == 5) {
                break;
            }

            int food = foodSupply.pop();
            int sta = stamina.poll();
            int sum = food + sta;

            if (!vihren) {
                if (sum >= 80) {
                    vihren = true;
                    peeks++;
                    conquered.add("Vihren");
                }
            } else if (!kutelo) {
                if (sum >= 90) {
                    kutelo = true;
                    peeks++;
                    conquered.add("Kutelo");
                }
            } else if (!banski) {
                if (sum >= 100) {
                    banski = true;
                    peeks++;
                    conquered.add("Banski Suhodol");
                }
            } else if (!polezhan) {
                if (sum >= 60) {
                    polezhan = true;
                    peeks++;
                    conquered.add("Polezhan");
                }
            } else if (!kamenitza) {
                if (sum >= 70) {
                    kamenitza = true;
                    peeks++;
                    conquered.add("Kamenitza");
                }
            }
        }

        if (peeks == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conquered.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String s : conquered) {
                System.out.println(s);
            }
        }
    }
}
