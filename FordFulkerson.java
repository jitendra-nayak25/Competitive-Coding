import java.util.*;

public class FordFulkerson {

    static boolean bfs(int[][] capacity, int source, int sink,
                       int[] parent) {

        int n = capacity.length;

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v = 0; v < n; v++) {

                if (!visited[v] && capacity[u][v] > 0) {

                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;

                    if (v == sink) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static int fordFulkerson(int[][] capacity,
                             int source,
                             int sink) {

        int n = capacity.length;

        int[][] residual = new int[n][n];

        // Copy original capacities
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                residual[i][j] = capacity[i][j];
            }
        }

        int[] parent = new int[n];

        int maxFlow = 0;

        // Find augmenting paths
        while (bfs(residual, source, sink, parent)) {

            int pathFlow = Integer.MAX_VALUE;

            // Find minimum capacity in path
            for (int v = sink; v != source; v = parent[v]) {

                int u = parent[v];

                pathFlow = Math.min(
                    pathFlow,
                    residual[u][v]
                );
            }

            // Update residual capacities
            for (int v = sink; v != source; v = parent[v]) {

                int u = parent[v];

                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {

        int[][] capacity = {

            // S  A  B  T
            { 0, 10, 10,  0 }, // S
            { 0,  0,  0, 10 }, // A
            { 0,  0,  0, 10 }, // B
            { 0,  0,  0,  0 }  // T
        };

        int source = 0;
        int sink = 3;

        int maxFlow =
            fordFulkerson(capacity, source, sink);

        System.out.println("Maximum Flow: " + maxFlow);
    }
}