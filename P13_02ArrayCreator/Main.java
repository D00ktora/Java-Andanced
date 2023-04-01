/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 19:52
 */
package P13_02ArrayCreator;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.create(Integer.class, 2, 2);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
