/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.3.2023 г.
 * Time: 7:02
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> log = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.contains("end")) {
            String[] inputArr = input.split("\\s+");
            String ip = inputArr[0].split("=")[1];
            String message = inputArr[1].split("=")[1];
            String user = inputArr[2].split("=")[1];

            if (!log.containsKey(user)) {
                Map<String, Integer> tempLogUser = new LinkedHashMap<>();
                tempLogUser.put(ip, 1);
                log.put(user, tempLogUser);
            } else {
                Map<String, Integer> tempLogUser = log.get(user);
                if (!tempLogUser.containsKey(ip)) {
                    tempLogUser.put(ip, 1);
                } else {
                    int messages = tempLogUser.get(ip);
                    messages++;
                    tempLogUser.put(ip, messages);
                }
                log.put(user, tempLogUser);
            }

            input = scanner.nextLine();
        }

        for (String user : log.keySet()) {
            System.out.println(user + ":");
            Map<String, Integer> currentUser = log.get(user);
            String[] tempArr = new String[currentUser.size()];
            int i = 0;
            for (String ip : currentUser.keySet()) {
                int messages = currentUser.get(ip);
                tempArr[i] = ip + " => " + messages;
                i++;
            }
            String result = String.join(", ",tempArr);
            System.out.printf("%s.%n",result);
        }
    }
}
