/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 9:31
 */
package P12_04RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    public Car(String model, int speed, int power, int cargoWeight, String cargoType,
                double tirePressure1, int tireAge1, double tirePressure2, int tireAge2,
                double tirePressure3, int tireAge3, double tirePressure4, int tireAge4) {
            this.model = model;
            this.engine = new Engine(speed, power);
            this.cargo = new Cargo(cargoWeight, cargoType);
            this.tires = new Tires(tirePressure1, tireAge1, tirePressure2, tireAge2, tirePressure3, tireAge3, tirePressure4, tireAge4);
    }

    @Override
    public String toString() {
        return this.model;
    }
}
