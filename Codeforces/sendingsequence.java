//https://codeforces.com/problemset/problem/1741/E
import java.util.Scanner;
import java.util.Arrays;

public class sendingsequence {

    static void testCase(Scanner sc) {
        int n = sc.nextInt();
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }

        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            if (i + b[i] <= n && dp[i - 1]) {
                dp[i + b[i]] = true;
            }
            if (i - b[i] - 1 >= 0 && dp[i - b[i] - 1]) {
                dp[i] = true;
            }
        }

        System.out.println(dp[n] ? "YES" : "NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int T = sc.nextInt();
            for (int tc = 0; tc < T; tc++) {
                testCase(sc);
            }
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
