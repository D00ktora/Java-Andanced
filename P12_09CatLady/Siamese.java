/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 21.3.2023 г.
 * Time: 18:59
 */
package P12_09CatLady;


public class Siamese extends Cat {
    private double decibelsOfMeows;
    private String type;

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public Siamese(String name, double decibelsOfMeows, String type) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.type, this.getName(), this.decibelsOfMeows);
    }
}
