/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:18
 */
package P07StreamsFilesAndDirectories;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\output1_05.txt";
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputPath)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            String line;
            int lineNumber = 1;
            while ((line = bufferedReader.readLine()) != null) {
                if (lineNumber % 3 == 0) {
                    out.println(line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
