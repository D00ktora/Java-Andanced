/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 19:27
 */
package P13_01JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar <T> {
    private Deque<T> stack;

    public void add(T element) {
        stack.push(element);
    }

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public T remove() {
        return stack.pop();
    }
}
