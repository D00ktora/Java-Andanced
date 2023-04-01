/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 8:37
 */
package P14_10Tuple;

public class Tuple<T, U, K> {
    private T item1;
    private U item2;
    private K item3;

    public Tuple(T item1, U item2, K item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public U getItem2() {
        return item2;
    }

    public void setItem2(U item2) {
        this.item2 = item2;
    }


    public K getItem3() {
        return item3;
    }

    public void setItem3(K item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.item1, this.item2, this.item3);
    }
}
