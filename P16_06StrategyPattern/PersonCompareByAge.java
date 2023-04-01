/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 8:23
 */
package P16_06StrategyPattern;

import java.util.Comparator;

public class PersonCompareByAge implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        return first.getAge() - second.getAge();
    }
}
