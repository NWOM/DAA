import java.io.*;
import java.util.*;

public class PrimMST {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int v;
        int av; /* EDGE ACQUIRING VERTEX */
        int wt;

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt; // Fixing the comparison logic
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, weight));
            graph[v2].add(new Edge(v2, v1, weight));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0)); // Fixing the Pair initialization
        boolean[] visited = new boolean[vertices];
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (visited[rem.v]) {
                continue;
            }
            visited[rem.v] = true;
            if (rem.av != -1) // Change rem.v to rem.av for correct output
                System.out.println("[" + rem.v + "@" + rem.wt + "]");
            /*NEIGHBORS*/
            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    pq.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }
        }
    }
}
