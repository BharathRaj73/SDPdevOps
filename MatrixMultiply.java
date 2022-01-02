import java.util.*;

class Matrix {
    int mat[][];
    int row, col;

    Matrix() {
        mat = null;
        row = col = 0;
    }

    Matrix(int order) {
        mat = new int[order][order];
        row = col = order;
    }

    void readMat(Scanner read) {
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                mat[r][c] = read.nextInt();
    }

    void printMat() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.print(mat[r][c] + " ");
            }
            System.out.println();
        }
    }

    Matrix matMultiply(Matrix m) {
        Matrix prod = new Matrix(this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                prod.mat[i][j] = 0;
                for (int k = 0; k < this.row; k++)
                    prod.mat[i][j] = prod.mat[i][j] + this.mat[i][k] * m.mat[k][j];
            }

        }
        return prod;
    }

}

public class MatrixMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matrix multiply app");
        System.out.println("Enter the order");
        int order = sc.nextInt();
        Matrix A = new Matrix(order);
        Matrix B = new Matrix(order);
        System.out.println("Eneter the order of first matrix");
        A.readMat(sc);
        System.out.println("Enter the order of second matrix");
        B.readMat(sc);
        System.out.println("1st matrix");
        A.printMat();
        System.out.println("2nd matrix");
        B.printMat();
        Matrix C = A.matMultiply(B);
        System.out.println("Multiplied Matrix is");
        C.printMat();
        sc.close();

    }
}