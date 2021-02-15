package Speed_Racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = term.nextLine().split("\\s+");
            String model = parts[0];
            double fuel = Double.parseDouble(parts[1]);
            double fuelCost = Double.parseDouble(parts[2]);

            Car car = new Car(model, fuel, fuelCost);
            cars.put(model, car);
        }

        String input = term.nextLine();

        while (!input.equals("End")){
            String carModel = input.split("\\s+")[1];
            int distance = Integer.parseInt(input.split("\\s+")[2]);

            if (!cars.get(carModel).carCanMove(distance)){
                System.out.println("Insufficient fuel for the drive");
            }

            input = term.nextLine();
        }

        for (Car car : cars.values()){
            System.out.println(car.toString());
        }
    }
}
