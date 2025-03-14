import java.util.*;

class RotateMatrix {
    public static void rotate90Clockwise(int[][] matrix, int n) {
        // Step 1: Transpose the matrix (swap elements across diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row (swap elements horizontally)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take matrix size input
        System.out.print("Enter matrix size (n x n): ");
        int n = sc.nextInt();

        // Initialize matrix
        int[][] matrix = new int[n][n];

        // Take matrix input
        System.out.println("Enter the matrix row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Rotate matrix
        rotate90Clockwise(matrix, n);

        // Print rotated matrix
        System.out.println("Rotated Matrix (90° Clockwise):");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        sc.close();
    }
}
