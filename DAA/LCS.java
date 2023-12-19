import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCS {

    static int[][] findLCSLengths(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    static void backtrackAllLCS(String X, String Y, int[][] dp, int i, int j, List<String> current, List<List<String>> allLCS) {
        if (i == 0 || j == 0) {
            List<String> lcs = new ArrayList<>(current);
            allLCS.add(lcs);
            return;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            current.add(0, String.valueOf(X.charAt(i - 1)));
            backtrackAllLCS(X, Y, dp, i - 1, j - 1, current, allLCS);
            current.remove(0);
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                backtrackAllLCS(X, Y, dp, i - 1, j, current, allLCS);
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                backtrackAllLCS(X, Y, dp, i, j - 1, current, allLCS);
            }
        }
    }

    static List<List<String>> findAllLCS(String X, String Y) {
        int[][] dp = findLCSLengths(X, Y);
        List<List<String>> allLCS = new ArrayList<>();
        backtrackAllLCS(X, Y, dp, X.length(), Y.length(), new ArrayList<>(), allLCS);
        return allLCS;
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";

        List<List<String>> allLCS = findAllLCS(X, Y);

        // Print all the LCSs
        for (List<String> lcs : allLCS) {
            System.out.println(String.join("", lcs));
        }
    }
}
/**
TC O(2^N) BACKTRACKING **/