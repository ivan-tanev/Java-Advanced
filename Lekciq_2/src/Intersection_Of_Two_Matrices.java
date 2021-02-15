import java.util.Scanner;

public class Intersection_Of_Two_Matrices {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int rows = Integer.parseInt(term.nextLine());
        int cols = Integer.parseInt(term.nextLine());

        char[][] firstMatrix = readMatrix(term, rows, cols);
        char[][] secondMatrix = readMatrix(term, rows, cols);

        char[][] output = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]){
                    output[row][col] = firstMatrix[row][col];
                    System.out.print(output[row][col] + " ");
                } else {
                    output[row][col] = '*';
                    System.out.print(output[row][col] + " ");
                }
            }
            System.out.println();
        }

    }

    private static char[][] readMatrix(Scanner term, int rows, int cols) {
        char[][] characterMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = term.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                characterMatrix[row][col] = input[col].charAt(0);
            }
        }
        return characterMatrix;
    }
}
