/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 22.3.2023 г.
 * Time: 5:38
 */
package P14_01GenericBox;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Box<T extends Comparable<T>> {
    private List<T> types = new ArrayList<>();

    public List<T> getTypes() {
        return types;
    }

    public void setTypes(List<T> types) {
        this.types = types;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (T type : types) {
            builder.append(type.getClass().getName());
            builder.append(": ");
            builder.append(type);
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

    public void swap(int first, int second) {
        Collections.swap(this.types, first, second);
    }

    public int getMaxElement(T element) {
        return(int) this.types.stream().filter(elementToCompare -> elementToCompare.compareTo(element) > 0)
                .count();

    }

}
