import java.util.*;
import java.io.*;
//PROBLEM LINK https://codeforces.com/contest/2032/problem/D
public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int[] p;
    static int n;
    static int testCases;

    static int D(int a, int b) {
        System.out.println("? " + a + " " + b);
        return in.nextInt();
    }

    static void D(int t) {
        p = new int[n + 1];
        PriorityQueue<Integer> set = new PriorityQueue<>();
        boolean find = false;

        for (int i = 2; i < n; ++i) {
            if (!find) {
                int answer = D(1, i);
                if (answer == -1) {
                    return;
                }
                set.add(i);
                if (answer == 0) {
                    find = true;
                    p[i] = 1;
                }
            } else {
                while (!set.isEmpty()) {
                    int nodes = set.poll();
                    int answer = D(i, nodes);
                    if (answer == 0) {
                        p[i] = nodes;
                        set.add(i);
                        break;
                    }
                }
            }
        }

        System.out.print("! ");
        for (int i = 1; i <= n - 1; ++i) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] Amit) throws IOException {
        testCases = in.nextInt();
        for (int t = 0; t < testCases; ++t) {
            D_input();
            D(t + 1);
        }
        out.flush();
    }

    private static void D_input() throws IOException {
        n = in.nextInt();
    }
}
