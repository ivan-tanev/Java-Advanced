import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String[] input = term.nextLine().split("\\s+");
        while (!input[0].equals("End")){
            String command = input[0];
            switch (command){
                case "Create":

                    break;
                case "Deposit":
                    int Id = Integer.parseInt(input[1]);
                    double amount = Double.parseDouble(input[2]);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input[1]);
                    break;
                case "GetInterest":
                    int ID = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);
                    break;
            }

            input = term.nextLine().split("\\s+");
        }
    }
}

//int n = Integer.parseInt(term.nextLine());
//
//        for (int i = 0; i < n; i++) {
//            String[] parts = term.nextLine().split("\\s+");
//
//            if (parts.length == 1){
//                Car car = new Car(parts[0]);
//                car.setBrand(parts[0]);
//                CarInfo carInfo = new CarInfo(car.getBrand(), car.getModel(), car.getHorsePower());
//            } else if (parts.length == 2){
//                Car car = new Car(parts[0], parts[1]);
//                car.setBrand(parts[0]);
//                car.setModel(parts[1]);
//                CarInfo carInfo = new CarInfo(car.getBrand(), car.getModel(), car.getHorsePower());
//            } else {
//                Car car = new Car(parts[0], parts[1], Integer.parseInt(parts[2]));
//                car.setBrand(parts[0]);
//                car.setModel(parts[1]);
//                car.setHorsePower(Integer.parseInt(parts[2]));
//                CarInfo carInfo = new CarInfo(car.getBrand(), car.getModel(), car.getHorsePower());
//            }
//        }