import java.util.Scanner;
import java.util.TreeSet;

public class Sets_Of_Elements {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String[] input = term.nextLine().split(" ");
        int firstLength = Integer.parseInt(input[0]);
        int secondLength = Integer.parseInt(input[1]);

        TreeSet<Integer> firstNumbers = new TreeSet<>();
        TreeSet<Integer> secondNumbers = new TreeSet<>();

        for (int i = 0; i < firstLength; i++) {
            int number = Integer.parseInt(term.nextLine());

            firstNumbers.add(number);
        }

        for (int i = 0; i < secondLength; i++) {
            int number = Integer.parseInt(term.nextLine());

            secondNumbers.add(number);
        }

        firstNumbers.retainAll(secondNumbers);

        for (Integer firstNumber : firstNumbers) {
            System.out.print(firstNumber + " ");
        }
    }
}
