/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:23
 */
package P07StreamsFilesAndDirectories;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {
        String path = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\Files-and-Streams";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(String.format("%s: [%d]", file.getName(), file.length()));
            }
        }
    }
}
