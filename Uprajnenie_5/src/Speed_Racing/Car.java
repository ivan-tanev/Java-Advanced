package Speed_Racing;

import java.util.Map;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer and distance traveled
    private String model;
    private double fuel;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuel, double fuelCost){
        this.model = model;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public boolean carCanMove(int distance) {
        double fuelNeeded = distance * this.fuelCost;

        if (fuelNeeded <= this.fuel){
            this.fuel -= fuelNeeded;
            this.distanceTraveled += distance;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }
}
