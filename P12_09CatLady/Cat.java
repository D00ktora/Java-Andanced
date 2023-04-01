/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 18:59
 */
package P12_09CatLady;

public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
