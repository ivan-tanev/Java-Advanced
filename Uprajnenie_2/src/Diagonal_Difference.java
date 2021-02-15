import java.util.Arrays;
import java.util.Scanner;

public class Diagonal_Difference {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(term.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int primarySum = 0;
        for (int i = 0; i < n; i++) {
            int current = matrix[i][i];
            primarySum = primarySum + current;
        }

        int secondarySum = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (col == n - row - 1){
                    int current = matrix[row][col];
                    secondarySum = secondarySum + current;
                }
            }
        }

        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
