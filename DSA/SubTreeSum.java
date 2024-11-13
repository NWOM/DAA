import java.io.*;
import java.util.*;

public class SubTreeSum {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int[] value;
    static int time;
    static int[] start, end, lt;
    static List<Integer>[] adjacent;
    static long[] Ftree;

    // DFS to perform Euler Tour and record start and end times of nodes
    static void dfs(int node, int parent) {
        start[node] = time;
        lt[time++] = value[node];  // Store node value at entry time

        for (int child : adjacent[node]) {
            if (child != parent) {
                dfs(child, node);
            }
        }

        end[node] = time;
        lt[time++] = value[node];  // Store node value at exit time
    }

    // Build Fenwick Tree with initial values from Euler tour
    static void buildFT() {
        for (int i = 1; i < time; i++) {
            addFT(i, lt[i]);
        }
    }

    // Calculate prefix sum up to index `i` in Fenwick Tree
    static long sumFT(int i) {
        long sum = 0;
        while (i > 0) {
            sum += Ftree[i];
            i -= i & (-i);
        }
        return sum;
    }

    // Update Fenwick Tree at index `index` by `val`
    static void addFT(int index, long val) {
        while (index < Ftree.length) {
            Ftree[index] += val;
            index += index & (-index);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();  // Number of nodes
        int q = in.nextInt();  // Number of queries
        start = new int[n + 1];
        end = new int[n + 1];
        lt = new int[2 * n + 5];
        time = 1;
        value = in.nextIntArray1(n);

        // Initialize adjacency list
        adjacent = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjacent[i] = new ArrayList<>();
        }

        // Read edges and build tree
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adjacent[u].add(v);
            adjacent[v].add(u);
        }

        // Run DFS to compute Euler Tour
        dfs(1, 0);

        // Initialize Fenwick Tree and build it using Euler tour values
        Ftree = new long[lt.length];
        buildFT();

        // Process queries
        while (q-- > 0) {
            int t = in.nextInt();
            if (t == 1) {  // Update operation
                int v = in.nextInt();
                int newVal = in.nextInt();
                long delta = newVal - value[v];
                value[v] = newVal;

                // Update both start and end positions in Fenwick Tree
                addFT(start[v], delta);
                addFT(end[v], delta);
            } else {  // Query operation
                int v = in.nextInt();
                long sum = sumFT(end[v]) - sumFT(start[v]);
                sum /= 2;  // Each node's value is counted twice in the Euler Tour
                out.println(sum);
            }
        }
        out.close();
    }

    private static class InputReader implements AutoCloseable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public int[] nextIntArray1(int n) throws IOException {
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }
}
