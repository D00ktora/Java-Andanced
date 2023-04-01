/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:19
 */
package P07StreamsFilesAndDirectories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P06SortLines {
    public static void main(String[] args) {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\output1_06.txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            Files.readAllLines(Paths.get(inputPath))
                    .stream()
                    .filter(s -> !s.isEmpty())
                    .sorted()
                    .forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
