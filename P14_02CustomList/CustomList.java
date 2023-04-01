/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 7:05
 */
package P14_02CustomList;

import java.util.*;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    public class CustomIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
    private List<T> tList = new ArrayList<>();
    private int count = 0;


    public void add(T element) {
        this.tList.add(element);
    }

    public T remove(int index) {
        return this.tList.remove(index);
    }

    public boolean contains(T element) {
        return this.tList.contains(element);
    }

    public void swap(int from, int to) {
        T tempElement = this.tList.get(from);
        this.tList.set(from, this.tList.get(to));
        this.tList.set(to, tempElement);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T t : tList) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T t = this.tList.stream().max((f, s) -> f.compareTo(s)).get();
        return t;
    }

    public T getMin() {
        T t = this.tList.stream().min((f, s) -> f.compareTo(s)).get();
        return t;
    }

    public void print() {
        for (T t : tList) {
            System.out.println(t);
        }
    }


    public List<T> getCollection() {
        return new ArrayList<>(this.tList);
    }

    public void setCollection(List<T> collection) {
        this.tList = collection;
    }


    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }
}
