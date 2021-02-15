import java.util.Arrays;
import java.util.Scanner;

public class Positions_Of {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String[] input = term.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(term.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int searchedNumber = Integer.parseInt(term.nextLine());

        boolean notFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == searchedNumber){
                    System.out.println(row + " " + col);
                    notFound = true;
                }
            }
        }
        if (!notFound){
            System.out.println("not found");
        }
    }
}
