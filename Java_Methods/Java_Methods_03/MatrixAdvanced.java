import java.util.Scanner;

public class MatrixAdvanced {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size (2 or 3): ");
        int size = sc.nextInt();

        int[][] matrix = generateMatrix(size, size);
        System.out.println("Matrix:");
        printMatrix(matrix);

        System.out.println("Transpose:");
        printMatrix(transpose(matrix));

        if (size == 2) {
            int det = determinant2x2(matrix);
            System.out.println("Determinant: " + det);
            if (det != 0) {
                System.out.println("Inverse:");
                printInverse2x2(matrix, det);
            } else {
                System.out.println("Inverse not possible (det = 0)");
            }
        } else if (size == 3) {
            int det = determinant3x3(matrix);
            System.out.println("Determinant: " + det);
            if (det != 0) {
                System.out.println("Inverse:");
                printInverse3x3(matrix, det);
            } else {
                System.out.println("Inverse not possible (det = 0)");
            }
        }
    }

    static int[][] generateMatrix(int r, int c) {
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = (int)(Math.random() * 10);
        return mat;
    }

    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    static int[][] transpose(int[][] mat) {
        int[][] t = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                t[j][i] = mat[i][j];
        return t;
    }

    static int determinant2x2(int[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    static int determinant3x3(int[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1]) -
               m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0]) +
               m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    static void printInverse2x2(int[][] m, int det) {
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1];
        inv[0][1] = -m[0][1];
        inv[1][0] = -m[1][0];
        inv[1][1] = m[0][0];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%.2f\t", inv[i][j] / det);
            }
            System.out.println();
        }
    }

    static void printInverse3x3(int[][] m, int det) {
        double[][] cof = new double[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cof[i][j] = cofactor(m, i, j);

        double[][] adj = transposeDouble(cof);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%.2f\t", adj[i][j] / det);
            }
            System.out.println();
        }
    }

    static double[][] transposeDouble(double[][] mat) {
        double[][] t = new double[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                t[j][i] = mat[i][j];
        return t;
    }

    static int cofactor(int[][] m, int row, int col) {
        int[][] sub = new int[2][2];
        int r = 0, c;
        for (int i = 0; i < 3; i++) {
            if (i == row) continue;
            c = 0;
            for (int j = 0; j < 3; j++) {
                if (j == col) continue;
                sub[r][c++] = m[i][j];
            }
            r++;
        }
        int cof = sub[0][0]*sub[1][1] - sub[0][1]*sub[1][0];
        return ((row + col) % 2 == 0) ? cof : -cof;
    }
}
