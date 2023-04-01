/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:32
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P01SumLines {
    public static void main(String[] args) {
        String input = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises\\input.txt";


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(input))) {
            String line = reader.readLine();
            while (line != null) {
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
