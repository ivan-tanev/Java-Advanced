import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals_OfSquareMatrix {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int num = Integer.parseInt(term.nextLine());

        int[][] matrix = new int[num][num];
        for (int row = 0; row < num; row++) {
            matrix[row] = Arrays.stream(term.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < num; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < num; i++) {
            System.out.print(matrix[(matrix.length - 1) - i][i] + " ");
        }
    }
}
