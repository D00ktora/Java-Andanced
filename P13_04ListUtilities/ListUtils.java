/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 20:31
 */
package P13_04ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static<T extends Comparable<T>> T getMin(List<T> tList) throws Exception {
        if (tList.isEmpty()) {

            throw new IllegalArgumentException("ERROR");
        }
        return Collections.min(tList);
    }
    public static<T extends Comparable<T>> T getMax(List<T> tList) {
        if (tList.isEmpty()) {
            throw new IllegalArgumentException("ERROR");
        }
        return Collections.max(tList);
    }
}
