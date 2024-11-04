import java.util.*;
import java.io.*;
// https://codeforces.com/problemset/problem/455/A
public class Boredom {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static long[] Dp;
    static long[] Arr;
    static long[] B;
    static long testCases;

    public static void main(String args[]) {
        testCases = in.nextLong();
        Arr = new long[(int) testCases];
        B = new long[100001]; 
        Dp = new long[100001]; 

        for (int i = 0; i < testCases; i++) {
            Arr[i] = in.nextLong();
            B[(int) Arr[i]]++;
        }

        Dp[0] = 0;
        Dp[1] = B[1];

        for (int i = 2; i < B.length; i++) {
            Dp[i] = Math.max(Dp[i - 1], B[i] * i + Dp[i - 2]);
        }

        System.out.println(Dp[B.length - 1]); 
        out.flush();
    }
}
