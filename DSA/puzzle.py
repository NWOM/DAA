import java.util.*;
import java.io.*;

public class Solution {
    private static final int MOD = 1000000007;

    public static int findWaysUtil(int[] num, int i, int tar, int[][] dp) {
        if (i == 0) {
            if (tar == 0 && num[i] == 0) return 2;
            if (tar == 0 || tar == num[i]) return 1;
            return 0;
        }
        if (dp[i][tar] != -1)
            return dp[i][tar];
        int pick = 0;
        if (tar >= num[i])
            pick = findWaysUtil(num, i - 1, tar - num[i], dp);
        int not_pick = findWaysUtil(num, i - 1, tar, dp);
        return dp[i][tar] = (pick + not_pick) % MOD;
    }

    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= tar; j++) {
                dp[i][j] = -1;
            }
        }
        return findWaysUtil(num, n - 1, tar, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements in array
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Input array elements
        int[] num = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int tar = sc.nextInt();

        // Calculate number of ways
        int result = findWays(num, tar);
        System.out.println("Number of ways to achieve the target: " + result);
    }
}
