/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 7:04
 */
package P16_03StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer> {
    private List<Integer> integerList;

    public Stack() {
        this.integerList = new ArrayList<>();
    }

    public void push(int... ints) {
        for (int anInt : ints) {
            this.integerList.add(0, anInt);
        }
    }
    public int pop() {
        int topElement = -1;
        if (this.integerList.size() > 0) {
            topElement = this.integerList.get(0);
            this.integerList.remove(0);
        } else {
            System.out.println("No elements");
        }
        return topElement;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < integerList.size();
            }

            @Override
            public Integer next() {
                int result = integerList.get(counter);
                this.counter++;
                return result;
            }
        };
    }
}
