/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:45
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P08GetFolderSize {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises\\Exercises Resources";
        Path folder = Paths.get(basePath);
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .filter(p -> !p.toFile().getName().equals("output.txt"))
                .filter(p -> !p.toFile().getName().equals("result.txt"))
                .mapToLong(p -> p.toFile().length())
                .sum();

        System.out.println(String.format("Folder size: %d", size));
    }
}
