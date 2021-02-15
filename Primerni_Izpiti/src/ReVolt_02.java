import java.util.Scanner;

public class ReVolt_02 {
    public static int playerRow;
    public static int playerCol;
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        int commandsCount = Integer.parseInt(term.nextLine());

        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = term.nextLine();
            if (line.contains("f")){
                playerRow = i;
                playerCol = line.indexOf('f');
            }
            matrix[i] = line.toCharArray();
        }
        boolean youLost = true;
        for (int i = 0; i < commandsCount; i++) {
            String command = term.nextLine();

            switch (command){
                case "up":
                    if (playerRow - 1 >= 0){
                        if (matrix[playerRow - 1][playerCol] == '-'){
                            matrix[playerRow][playerCol] = '-';
                            playerRow -= 1;
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow - 1][playerCol] == 'B'){
                            matrix[playerRow][playerCol] = '-';
                            playerRow -= 1;
                            if (playerRow - 1 >= 0){
                                matrix[playerRow][playerCol] = 'B';
                                playerRow -= 1;
                                matrix[playerRow][playerCol] = 'f';
                            } else {
                                matrix[playerRow][playerCol] = 'B';
                                playerRow = n - 1;
                                matrix[playerRow][playerCol] = 'f';
                            }
                        } else if (matrix[playerRow - 1][playerCol] == 'T'){

                        } else if (matrix[playerRow - 1][playerCol] == 'F'){
                            matrix[playerRow][playerCol] = '-';
                            playerRow -= 1;
                            youLost = doYouLost(n, matrix);
                            break;
                        }
                    } else {
                        if (playerRow == 0){
                            if(matrix[playerRow][playerCol] == 'T' || matrix[playerRow][playerCol] == 'B'){
                                playerRow = n;
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                playerRow = n;
                            }
                        }

                        if (matrix[playerRow - 1][playerCol] == '-'){
                            matrix[playerRow][playerCol] = '-';
                            playerRow = n - 1;
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow - 1][playerCol] == 'B'){
                            matrix[playerRow][playerCol] = '-';
                            playerRow -= 1;
                            if (playerRow - 1 >= 0){
                                matrix[playerRow][playerCol] = 'B';
                                playerRow -= 1;
                                matrix[playerRow][playerCol] = 'f';
                            } else {
                                matrix[playerRow][playerCol] = 'B';
                                playerRow = n - 1;
                                matrix[playerRow][playerCol] = 'f';
                            }
                        } else if (matrix[playerRow - 1][playerCol] == 'T'){

                        } else if (matrix[playerRow - 1][playerCol] == 'F'){
                            matrix[playerRow][playerCol] = '-';
                            playerRow -= 1;
                            youLost = doYouLost(n, matrix);
                        }
                    }
                    break;
                case "down":
                    break;
                case "left":
                    break;
                case "right":
                    break;
            }
        }










        if (youLost){
            printMatrix(n, matrix);
        }
    }

    private static boolean doYouLost(int n, char[][] matrix) {
        boolean youLost;
        if (playerRow - 1 >= 0) {
            matrix[playerRow][playerCol] = 'f';
            printMatrix(n, matrix);
            return youLost = false;
        } else {
            matrix[playerRow][playerCol] = '-';
            playerRow = n - 1;
            matrix[playerRow][playerCol] = 'f';
            printMatrix(n, matrix);
            return youLost = false;
        }
    }

    private static void printMatrix(int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private void upMatrix(int row, int col){

    }
}
