/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:35
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P03ALLCAPITALS {
    public static void main(String[] args) {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\output_1.txt";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File(inputPath))));
             PrintWriter out = new PrintWriter(new FileWriter(outPath))) {


            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
