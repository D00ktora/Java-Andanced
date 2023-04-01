/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 7:59
 */
package P07StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02WriteToFile {
    public static void main(String[] args) {
        String path = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\input.txt";
        String output = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\output1_02.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');


        try (InputStream in = new FileInputStream(path); OutputStream out = new FileOutputStream(output)) {
            int oneByte = 0;

            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

