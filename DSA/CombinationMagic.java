import java.util.*;

public class CombinationMagic {
    // Find number of unique combinations whose sum is equal to the target
    static class Pair {
        int i;
        int j;
        String psf;

        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        boolean dp[][] = new boolean[n + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        if (j >= arr[i - 1]) {
                            if (dp[i - 1][j - arr[i - 1]]) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[n][target]);

        int count = 0; // Initialize the counter for unique combinations
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, target, ""));
        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            if (rem.i == 0 && rem.j == 0) {
                System.out.println(rem.psf.trim());
                count++;
            } else {
                if (rem.i > 0 && dp[rem.i - 1][rem.j]) {
                    queue.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
                if (rem.i > 0 && rem.j >= arr[rem.i - 1] && dp[rem.i - 1][rem.j - arr[rem.i - 1]]) {
                    queue.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], arr[rem.i - 1] + " " + rem.psf));
                }
            }
        }

        System.out.println("Number of unique combinations: " + count);
    }
}
