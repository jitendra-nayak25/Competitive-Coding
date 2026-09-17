public class MatrixAddition {

    public static void main(String[] args) {

        int[][] A = {
            {10, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        int[][] C = new int[2][2];

        // Adding two matrices
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // Display result
        System.out.println("Result of Matrix Addition:");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}