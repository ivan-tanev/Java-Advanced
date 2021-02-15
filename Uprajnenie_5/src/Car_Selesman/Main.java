package Car_Selesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = term.nextLine().split("\\s+");
            String model = parts[0];
            int power = Integer.parseInt(parts[1]);
            Engine engine;

            if (parts.length == 2){
                engine = new Engine(model, power);

            } else if (parts.length == 4){
                int displacement = Integer.parseInt(parts[2]);
                String efficiency = parts[3];

                engine = new Engine(model, power, displacement, efficiency);

            } else {
                try {
                    int displacement = Integer.parseInt(parts[2]);

                    engine = new Engine(model, power, displacement);

                } catch (NumberFormatException myException){
                    String efficiency = parts[2];

                    engine = new Engine(model, power, efficiency);

                }
            }
            engines.add(engine);
        }

        int m = Integer.parseInt(term.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] tokens = term.nextLine().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];
            Car car;

            if (tokens.length == 2){
                car = new Car(model, engine);

            } else if (tokens.length == 4){
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];

                car = new Car(model, engine, weight, color);

            } else {
                try {
                    int weight = Integer.parseInt(tokens[2]);

                    car = new Car(model, engine, weight);

                } catch (NumberFormatException otherException){
                    String color = tokens[2];

                    car = new Car(model, engine, color);

                }
            }
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine() + ":");
            engines.forEach(engine -> {
                if (engine.getModel().equals(car.getEngine())){
                    System.out.println(engine.toString());
                }
            });
            if (car.getWeight() == 0){
                System.out.println("Weight: n/a");
            } else {
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}
