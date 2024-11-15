import java.util.*;

public class GraphColorConnectivity {
    static class Edge {
        int dest, color;

        Edge(int dest, int color) {
            this.dest = dest;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int n = sc.nextInt();
        int m = sc.nextInt();

       
        ArrayList<Edge>[] adjacent = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjacent[i] = new ArrayList<>();
        }

        
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int color = sc.nextInt();
            adjacent[v1].add(new Edge(v2, color));
            adjacent[v2].add(new Edge(v1, color));
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int colorCount = 0;

            for (int c = 1; c <= m; c++) {
                boolean[] visited = new boolean[n + 1];
                if (isConnected(u, v, c, adjacent, visited)) {
                    colorCount++;
                }
            }

            System.out.println(colorCount);
        }
    }

    static boolean isConnected(int u, int v, int color, ArrayList<Edge>[] adjacent, boolean[] visited) {
        if (u == v) return true;
        visited[u] = true;

        for (Edge edge : adjacent[u]) {
            if (edge.color == color && !visited[edge.dest]) {
                if (isConnected(edge.dest, v, color, adjacent, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
