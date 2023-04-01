/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 18:59
 */
package P12_09CatLady;

public class Cymric extends Cat{
    private double furLength;
    private String type;

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    public Cymric(String name, double furLength, String type) {
        super(name);
        this.furLength = furLength;
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.type, this.getName(), this.furLength);
    }
}
