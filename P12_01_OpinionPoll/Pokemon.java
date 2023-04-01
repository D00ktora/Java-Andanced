/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 18:18
 */
package P12_01_OpinionPoll;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.type);
    }
}
