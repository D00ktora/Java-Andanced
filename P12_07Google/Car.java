/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 18:19
 */
package P12_07Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.model, this.speed);
    }
}
