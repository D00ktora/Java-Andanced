/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 20:15
 */
package P13_03GenericScale;


import java.util.Comparator;
import java.util.function.Function;


public class Scale<T extends Comparable<T>>  {
    private T left;
    private T right;

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public T getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (this.left.compareTo(this.right) > 0) {
            return this.left;
        } else if (this.left.compareTo(this.right) < 0) {
            return this.right;
        }
        return null;
    }

}
