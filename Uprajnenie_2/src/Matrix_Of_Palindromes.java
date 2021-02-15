import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Of_Palindromes {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(term.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];

        char symbol = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + symbol +(char) (symbol + col) + symbol;
            }
            symbol = (char) (symbol + 1);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
