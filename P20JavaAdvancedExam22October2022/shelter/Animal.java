/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.4.2023 г.
 * Time: 18:09
 */
package P20JavaAdvancedExam22October2022.shelter;

public class Animal {
    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String caretaker) {
        this.name = name;
        this.age = age;
        this.caretaker = caretaker;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", this.name, this.age, this.caretaker);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }
}
