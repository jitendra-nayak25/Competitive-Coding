public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] p = {10, 30, 5, 60};

        int n = p.length - 1;

        int[][] dp = new int[n + 1][n + 1];

        
        for (int length = 2; length <= n; length++) {

            for (int i = 1; i <= n - length + 1; i++) {

                int j = i + length - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + p[i - 1] * p[k] * p[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        System.out.println(
            "Minimum multiplication cost: " + dp[1][n]
        );
    }
}