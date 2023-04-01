/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 16:24
 */
package P12_05CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private  String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power, String displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
