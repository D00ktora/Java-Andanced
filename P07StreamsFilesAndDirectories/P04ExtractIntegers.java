/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:12
 */
package P07StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\input.txt";
        String output = "D:\\IntelliJ\\SoftUniWithJava\\JavaAdvance\\src\\P07StreamsFilesAndDirectories\\output1_04.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        PrintWriter out = new PrintWriter(new FileOutputStream(output));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                out.println(scanner.nextInt());
            }
            scanner.next();
        }
        out.close();
    }
}
