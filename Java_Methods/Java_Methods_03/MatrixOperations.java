import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] A = generateMatrix(rows, cols);
        int[][] B = generateMatrix(rows, cols);

        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("Addition:");
        printMatrix(addMatrix(A, B));

        System.out.println("Subtraction:");
        printMatrix(subtractMatrix(A, B));

        if (cols == rows) {
            System.out.println("Multiplication:");
            printMatrix(multiplyMatrix(A, B));
        } else {
            System.out.println("Multiplication not possible (cols of A != rows of B)");
        }
    }

    static int[][] generateMatrix(int rows, int cols) {
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = (int)(Math.random() * 10);
        return mat;
    }

    static int[][] addMatrix(int[][] A, int[][] B) {
        int[][] res = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                res[i][j] = A[i][j] + B[i][j];
        return res;
    }

    static int[][] subtractMatrix(int[][] A, int[][] B) {
        int[][] res = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                res[i][j] = A[i][j] - B[i][j];
        return res;
    }

    static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < A[0].length; k++)
                    res[i][j] += A[i][k] * B[k][j];
        return res;
    }

    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }
}
