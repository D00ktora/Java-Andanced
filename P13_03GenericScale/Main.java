/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 20:14
 */
package P13_03GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "b");
        System.out.println(stringScale.getHeavier());
        Scale<Integer> integerScale = new Scale<>(1,2);
        System.out.println(integerScale.getHeavier());
    }
}
