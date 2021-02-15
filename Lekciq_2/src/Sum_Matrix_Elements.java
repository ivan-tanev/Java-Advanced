import java.util.Arrays;
import java.util.Scanner;

public class Sum_Matrix_Elements {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int[] input = Arrays.stream(term.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(term.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum = sum + matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
