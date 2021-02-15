import java.util.Scanner;

public class Garden_02 {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);

        String[] size = term.nextLine().split("\\s+");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        int[][] matrix = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = 0;
            }
        }
        String input = term.nextLine();
        while(!input.equals("Bloom Bloom Plow")) {
            int rows = Integer.parseInt(input.split("\\s+")[0]);
            int cols = Integer.parseInt(input.split("\\s+")[1]);

            if (isOutOfBounds(rows, cols, matrix)){
                System.out.println("Invalid coordinates.");
            } else {
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < m; col++) {
                        if (rows == row){
                            matrix[row][col] += 1;
                        } else if (cols == col){
                            matrix[row][col] += 1;
                        }
                    }
                }
            }
            input = term.nextLine();
        }



        printMatrix(matrix);

    }
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(int row, int col, int[][] matrix) {
        return row < 0 || row >= matrix.length
                || col < 0 || col >= matrix[row].length;
    }
}
