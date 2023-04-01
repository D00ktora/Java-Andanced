/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:41
 */
package P08StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class P06WordCount {
    public static void main(String[] args) {
        String basePath = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P08StreamsFilesAndDirectoriesExercises";

        String inputPath = basePath + "\\words.txt";
        String search = basePath + "\\text.txt";
        String outPath = basePath + "\\output_4.txt";
        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();

        try (
                BufferedReader wordsReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputPath)
                                )
                        )
                );
                BufferedReader textReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(search)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            String line;

            while ((line = wordsReader.readLine()) != null) {
                Arrays.stream(line.trim().split("\\s+")).forEach(word -> {
                    words.putIfAbsent(word, 0);
                });
            }


            while ((line = textReader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String word : tokens) {
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    }
                }
            }

            words.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(entry -> {
                        out.println(String.format("%s - %d", entry.getKey(), entry.getValue()));
                    });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
