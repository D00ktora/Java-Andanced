/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 19:00
 */
package P12_09CatLady;

public class StreetExtraordinaire extends Cat{
    private double earSize;
    private String type;

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    public StreetExtraordinaire(String name, double earSize, String type) {
        super(name);
        this.earSize = earSize;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.type, this.getName(), this.earSize);
    }
}
