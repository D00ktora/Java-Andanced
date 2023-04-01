/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:07
 */
package P07StreamsFilesAndDirectories;

import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) {
        String path = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\input.txt";
        String output = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\output1_03.txt";

        try (InputStream in = new FileInputStream(path); OutputStream out = new FileOutputStream(output)) {
            int oneByte = 0;

            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
