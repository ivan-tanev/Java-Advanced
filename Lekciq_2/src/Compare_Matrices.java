import java.util.Scanner;

public class Compare_Matrices {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(term);
        int[][] secondMatrix = readMatrix(term);

        if (matrixComparison(firstMatrix, secondMatrix)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean matrixComparison(int[][] firstMatrix, int[][] secondMatrix) {
        boolean areEqual = false;
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            int[] firstArray = firstMatrix[i];
            int[] secondArray = secondMatrix[i];

            if (firstArray.length != secondArray.length){
                return false;
            }
            for (int j = 0; j < firstArray.length; j++) {
                if (firstArray[j] != secondArray[j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner term) {
        String[] input = term.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String [] numbers = term.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return matrix;
    }
}
