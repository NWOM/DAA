import java.util.Scanner;
//https://codeforces.com/problemset/problem/463/D
public class gp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] p = new int[k + 1][n + 1];
        int[][] position = new int[k + 1][n + 1];
        int[] max_length_till = new int[n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = sc.nextInt();
                int element = p[i][j];
                position[i][element] = j;
            }
        }

        int ans = 1;

        for (int i = 1; i <= n; i++) {
            max_length_till[i] = 1; 
            for (int j = 1; j < i; j++) {
                int current = p[1][i];
                int previous = p[1][j];
                boolean flag = true;

                for (int kk = 1; kk <= k; kk++) {
                    if (position[kk][previous] > position[kk][current]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    max_length_till[i] = Math.max(max_length_till[i], max_length_till[j] + 1);
                }
            }
            ans = Math.max(ans, max_length_till[i]);
        }

        System.out.println(ans);
    }
}
