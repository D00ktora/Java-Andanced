/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 8:04
 */
package P14_02CustomList;


import java.util.List;

public class Sorter {
    public static <T extends Comparable> void sort(CustomList<String> list) {
        List<String> sortedCollection = list.getCollection();
        sortedCollection.sort(Comparable::compareTo);
        list.setCollection(sortedCollection);
    }
}
