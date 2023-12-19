public class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1; // Number of matrices in the chain
        int[][] m = new int[n + 1][n + 1]; // Table to store minimum scalar multiplications

        // Cost is 0 when multiplying one matrix
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        // Fill the table using bottom-up dynamic programming
        for (int chainLen = 2; chainLen <= n; chainLen++) {
            for (int i = 1; i <= n - chainLen + 1; i++) {
                int j = i + chainLen - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }

        return m[1][n];
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 30, 5, 60}; // Example dimensions of matrices
        int minMultiplications = matrixChainOrder(dimensions);
        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
}
