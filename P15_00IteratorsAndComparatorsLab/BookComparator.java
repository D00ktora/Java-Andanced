/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 14:32
 */
package P15_00IteratorsAndComparatorsLab;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{


    @Override
    public int compare(Book first, Book second) {
        int result = first.getTitle().compareTo(second.getTitle());

        if (result == 0) {
            result = Integer.compare(first.getYear(),second.getYear());
        }
        return result;
    }
}
