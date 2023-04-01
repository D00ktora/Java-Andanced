/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 8:16
 */
package P16_06StrategyPattern;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
