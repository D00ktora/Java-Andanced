/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:37
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class P04CountCharacterTypes {
    public static void main(String[] args) {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises";

        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\output_2.txt";

        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        List<String> punctuations = Arrays.asList("!", ",", ".", "?");

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
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.replaceAll("\\s+", "").split("");
                for (String token : tokens) {
                    if (vowels.contains(token)) {
                        vowelsCount += 1;
                    } else if (punctuations.contains(token)) {
                        punctuationCount += 1;
                    } else {
                        consonantsCount += 1;
                    }
                }
            }

            out.write(String.format("Vowels: %d\n", vowelsCount));
            out.write(String.format("Other symbols: %d\n", consonantsCount));
            out.write(String.format("Punctuation: %d", punctuationCount));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
