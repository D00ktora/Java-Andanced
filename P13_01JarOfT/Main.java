/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 19:27
 */
package P13_01JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar<>();

        jar.add("First");
        jar.add("Second");
        jar.add("Third");

        System.out.println(jar.remove());
    }
}
