import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Sum_Of_2x2_Submatrix {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int[] demensions = Arrays.stream(term.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = demensions[0];
        int cols = demensions[1];

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(term.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int max = Integer.MIN_VALUE;
        int[][] biggestMatrix = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (max <= sum){
                    max = sum;
                    biggestMatrix[0][0] = matrix[row][col];
                    biggestMatrix[0][1] = matrix[row][col + 1];
                    biggestMatrix[1][0] = matrix[row + 1][col];
                    biggestMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(biggestMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }
}
