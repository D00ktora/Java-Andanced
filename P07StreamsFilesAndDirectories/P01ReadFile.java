/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 7:47
 */
package P07StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class P01ReadFile {

    public static void main(String[] args) {

        String path = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ",
                        Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
