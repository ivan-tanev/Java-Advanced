import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReVolt_ne_e_moq_02 {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bfr.readLine());
        int commandsCnt = Integer.parseInt(bfr.readLine());

        int xPos = -1;
        int yPos = -1;
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String input = bfr.readLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'f') {
                    xPos = row;
                    yPos = col;
                    matrix[xPos][yPos] = '-';
                }
            }
        }
        boolean playerWon = false;
        while (commandsCnt-- > 0) {
            String command = bfr.readLine();
            if (matrix[xPos][yPos] == '-') {
                if (command.equals("left")) {
                    yPos = moveLeft(n, yPos);
                } else if (command.equals("right")) {
                    yPos = moveRight(n, yPos);
                } else if (command.equals("up")) {
                    xPos = moveUp(n, xPos);
                } else if (command.equals("down")) {
                    xPos = moveDown(n, xPos);
                }
            }
            if (matrix[xPos][yPos] == 'B') {
                if (command.equals("left")) {
                    yPos = moveLeft(n, yPos);
                } else if (command.equals("right")) {
                    yPos = moveRight(n, yPos);
                } else if (command.equals("up")) {
                    xPos = moveUp(n, xPos);
                } else if (command.equals("down")) {
                    xPos = moveDown(n, xPos);
                }
            } else if (matrix[xPos][yPos] == 'T') {
                if (command.equals("left")) {
                    yPos = moveRight(n, yPos);
                } else if (command.equals("right")) {
                    yPos = moveLeft(n, yPos);
                } else if (command.equals("up")) {
                    xPos = moveDown(n, xPos);
                } else if (command.equals("down")) {
                    xPos = moveUp(n, xPos);
                }
            } else if (matrix[xPos][yPos] == 'F') {
                playerWon = true;
                break;
            }
        }
        matrix[xPos][yPos] = 'f';
        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }

    }

    private static int moveUp(int n, int xPos) {
        xPos--;
        if (xPos < 0) {
            xPos = n - 1;
        }
        return xPos;
    }

    private static int moveDown(int n, int xPos) {
        xPos++;
        if (xPos >= n) {
            xPos = 0;
        }
        return xPos;
    }

    private static int moveLeft(int n, int yPos) {
        yPos--;
        if (yPos < 0) {
            yPos = n - 1;
        }
        return yPos;
    }


    private static int moveRight(int n, int yPos) {
        yPos++;
        if (yPos >= n) {
            yPos = 0;
        }
        return yPos;
    }

}
