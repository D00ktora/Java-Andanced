/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 8:01
 */
package P16_05ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.name.compareTo(other.getName());
        if (result == 0) {
            result = Integer.compare(this.age, other.getAge());
            if (result == 0) {
                result = this.town.compareTo(other.getTown());
            }
        }
        return result;
    }
}
