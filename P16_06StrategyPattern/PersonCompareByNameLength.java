/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 8:17
 */
package P16_06StrategyPattern;

import java.util.Comparator;

public class PersonCompareByNameLength implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result = Integer.compare(first.getName().length(), second.getName().length());
        if (result == 0) {
            char firstChar = first.getName().toLowerCase().charAt(0);
            char secondChar = second.getName().toLowerCase().charAt(0);
            result = firstChar - secondChar;
        }
        return result;
    }
}
