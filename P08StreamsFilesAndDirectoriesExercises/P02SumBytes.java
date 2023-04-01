/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:34
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02SumBytes {
    public static void main(String[] args) {
        String input = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises\\input.txt";


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(input))) {
            String line = reader.readLine();
            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = reader.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
