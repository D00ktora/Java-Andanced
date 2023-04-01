/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 15:57
 */
package P12_04RawData;

public class Cargo {
    private int weight;
    private String type;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
}
