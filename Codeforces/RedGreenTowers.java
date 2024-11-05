import java.util.Scanner;
//https://codeforces.com/problemset/problem/478/D
public class RedGreenTowers {
    static final long MOD = 1000000007;
    static final int M = 200010;
    static long[] dp = new long[M];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long r = scanner.nextLong();
        long g = scanner.nextLong();
        long sum = r + g;
        long max_h = (long) ((Math.sqrt(1.0 + 8 * sum) - 1.0) / 2.0);

        dp[0] = 1;
        for (int h = 1; h <= max_h; h++) {
            for (int i = (int) Math.min(r, (h * (h + 1)) / 2); i >= h; i--) {
                dp[i] = (dp[i] + dp[i - h]) % MOD;
            }
        }

        long ans = 0;
        long total_balls = (max_h * (max_h + 1)) / 2;
        for (int i = 0; i <= r; i++) {
            if (total_balls - i <= g) {
                ans = (ans + dp[i]) % MOD;
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}
