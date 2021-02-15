import java.util.LinkedHashSet;
import java.util.Scanner;

public class Parking_Lot {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String[] input = term.nextLine().split(", ");
        LinkedHashSet<String> carNumbers = new LinkedHashSet<>();

        while (!input[0].equals("END")){
            String command = input[0];
            String plateNumber = input[1];

            switch (command){
                case "IN":
                    carNumbers.add(plateNumber);
                    break;
                case "OUT":
                    carNumbers.remove(plateNumber);
                    break;
            }

            input = term.nextLine().split(", ");
        }

        if (carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        }
    }
}
