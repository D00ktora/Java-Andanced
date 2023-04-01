/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:43
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P07MergeTwoFiles {
    public static void main(String[] args) {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises";

        String inputOnePath = basePath + "\\inputOne.txt";
        String inputTwoPath = basePath + "\\inputTwo.txt";
        String outPath = basePath + "\\output_5.txt";

        try (
                BufferedReader inputOneReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputOnePath)
                                )
                        )
                );
                BufferedReader inputTwoReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputTwoPath)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            String line;

            while ((line = inputOneReader.readLine()) != null) {
                out.println(line);
            }


            while ((line = inputTwoReader.readLine()) != null) {
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
