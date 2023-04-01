/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:26
 */
package P07StreamsFilesAndDirectories;

import java.io.File;
import java.util.*;

public class P08NestedFolders {
    public static void main(String[] args) {
        String path = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\Files-and-Streams";

        File dir = new File(path);

        Deque<File> files = new ArrayDeque<>();
        files.addLast(dir);
        List<String> folders = new ArrayList<>();

        while (! files.isEmpty()) {
            File currentDir = files.removeFirst();
            if (currentDir.isDirectory()) {
                for (File file : Objects.requireNonNull(currentDir.listFiles())) {
                    if (file.isDirectory()) {
                        files.addLast(file);
                    }
                }
                folders.add(currentDir.getName());
            }
        }
        folders.forEach(System.out::println);
        System.out.println(String.format("%d folders", folders.size()));
    }
}
