import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix(2, 3);
        Matrix B = new Matrix(2, 3);
        A.populateRandom();
        B.populateRandom();

        System.out.println("A:");
        System.out.print(A);
        System.out.println("B:");
        System.out.print(B);

        System.out.println("A + B:");
        System.out.print(A.add(B));

        Matrix C = new Matrix(3, 2);
        C.populateRandom();
        System.out.println("C:");
        System.out.print(C);

        System.out.println("A x C:");
        System.out.print(A.multiply(C));

        try {
            System.out.println("Attempting A + C (should fail):");
            System.out.print(A.add(C));
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught expected exception: " + ex.getMessage());
        }

        try {
            System.out.println("Attempting B x B (should fail):");
            System.out.print(B.multiply(B));
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught expected exception: " + ex.getMessage());
        }
    }
}

class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) throw new IllegalArgumentException("rows/cols must be > 0");
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0)
            throw new IllegalArgumentException("data must be non-empty");
        int rows = data.length, cols = data[0].length;
        this.data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) throw new IllegalArgumentException("jagged arrays not allowed");
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    public void populateRandom() {
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = r.nextInt(10) + 1;
            }
        }
    }

    public Matrix add(Matrix other) {
        if (other == null) throw new IllegalArgumentException("other is null");
        if (data.length != other.data.length || data[0].length != other.data[0].length)
            throw new IllegalArgumentException("dimension mismatch for add");
        int rows = data.length, cols = data[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(res);
    }

    public Matrix multiply(Matrix other) {
        if (other == null) throw new IllegalArgumentException("other is null");
        int m = data.length;
        int n = data[0].length;
        int p = other.data[0].length;
        if (n != other.data.length)
            throw new IllegalArgumentException("dimension mismatch for multiply");
        int[][] res = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < p; k++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += data[i][j] * other.data[j][k];
                }
                res[i][k] = sum;
            }
        }
        return new Matrix(res);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j < row.length - 1) sb.append('\t');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
