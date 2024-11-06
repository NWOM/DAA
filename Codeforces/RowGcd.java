import java.util.*;
import java.io.*;
// https://codeforces.com/contest/1458/problem/A
public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) {
        int n = in.nextInt();
        int m = in.nextInt();
        long first[] = new long[n];  
        long second[] = new long[m]; 

        for (int i = 0; i < n; i++) {
            first[i] = in.nextLong();
        }
        for (int j = 0; j < m; j++) {
            second[j] = in.nextLong(); 
        }

        
        long gcdOfDifferences = 0;
        for (int i = 1; i < n; i++) {
            gcdOfDifferences = gcd(gcdOfDifferences, Math.abs(first[i] - first[0]));
        }

        long[] res = new long[m];
        for (int i = 0; i < m; i++) {
            res[i] = gcd(first[0] + second[i], gcdOfDifferences);
        }

        for (int i = 0; i < m; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        out.flush();
        in.close();
    }

    private static long gcd(long a, long b) { 
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
