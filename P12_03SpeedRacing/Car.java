/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 9:05
 */
package P12_03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private static int travelStart = 0;
    private int travel;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.travel = travelStart;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public static int getTravelStart() {
        return travelStart;
    }

    public static void setTravelStart(int travelStart) {
        Car.travelStart = travelStart;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, travel);
    }

    public boolean isFuelEnough(int distance) {
        double neededFuel = distance * fuelCost;
        if (neededFuel <= getFuelAmount()) {
            return true;
        }
        return false;
    }
}
