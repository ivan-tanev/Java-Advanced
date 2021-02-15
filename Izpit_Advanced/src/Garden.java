import java.util.Scanner;

public class Garden {
    public static int food = 0;
    public static int rowSnake = 0, colSnake = 0;
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        int m = Integer.parseInt(term.nextLine());

        int[][] matrix = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = 0;
            }
        }

        while (food < 10) {
            String command = term.nextLine();

            if (command.equals("up")) {
                // row - 1
                if (isOutOfBounds(rowSnake - 1, colSnake, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake,
                            rowSnake - 1, colSnake, matrix)) {
                        rowSnake--;
                    }
                }
            } else if (command.equals("down")) {
                // row + 1
                if (isOutOfBounds(rowSnake + 1, colSnake, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake,
                            rowSnake + 1, colSnake, matrix)) {
                        rowSnake++;
                    }
                }
            } else if (command.equals("left")) {
                // col - 1
                if (isOutOfBounds(rowSnake, colSnake - 1, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake,
                            rowSnake, colSnake - 1, matrix)) {
                        colSnake--;
                    }
                }
            } else if (command.equals("right")) {
                // col + 1
                if (isOutOfBounds(rowSnake, colSnake + 1, matrix)) {
                    break;
                } else {
                    if (!moveSnake(rowSnake, colSnake,
                            rowSnake, colSnake + 1, matrix)) {
                        colSnake++;
                    }
                }
            }
        }

        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            matrix[rowSnake][colSnake] = '.';
            System.out.println("Game over!");
        }

        System.out.println("Food eaten: " + food);

        printMatrix(matrix);
    }

    private static boolean moveSnake(int oldRow, int oldCol,
                                     int newRow, int newCol, int[][] matrix) {
        if (matrix[newRow][newCol] == '-') {
            matrix[newRow][newCol] = 'S';
        } else if (matrix[newRow][newCol] == '*') {
            matrix[newRow][newCol] = 'S';
            food++;
        } else if (matrix[newRow][newCol] == 'B') {
            // which burrow is the snake at ?
            // where is the other one ?
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B'
                            && (row != newRow || col != newCol)) {
                        matrix[row][col] = 'S';
                        matrix[newRow][newCol] = '.';
                        matrix[oldRow][oldCol] = '.';
                        rowSnake = row;
                        colSnake = col;
                        return true;
                    }
                }
            }
        }

        matrix[oldRow][oldCol] = '.';
        return false;
    }

    private static boolean isOutOfBounds(int row, int col, int[][] matrix) {
        return row < 0 || row >= matrix.length
                || col < 0 || col >= matrix[row].length;
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return !isOutOfBounds(row, col, matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
