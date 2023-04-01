/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 14:53
 */
package P16_01ListyIterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int counter = 0;

    public ListyIterator(String... list) {
        this.list = Arrays.stream(list).collect(Collectors.toList());
    }

    public boolean move() {
        boolean result = this.counter < this.list.size() - 1;
        if (result == true) {
            this.counter++;
        }
        return result;
    }

    public boolean hasNext() {
        return this.counter < this.list.size() - 1;
    }

    public void print() {
        if (this.list.isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        } else {
            System.out.println(this.list.get(this.counter));
        }
    }

    public void printAll() {
            System.out.println(String.join(" ", list));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index < list.size() - 1;
            }

            @Override
            public String next() {
                return list.get(index);
            }
        };
    }
}
