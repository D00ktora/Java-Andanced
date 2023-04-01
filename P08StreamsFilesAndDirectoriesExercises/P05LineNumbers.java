/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:40
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises";

        String inputPath = basePath + "\\inputLineNumbers.txt";
        String outPath = basePath + "\\output_3.txt";

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputPath)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            int lineCount = 1;

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(String.format("%d. %s", lineCount++, line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
