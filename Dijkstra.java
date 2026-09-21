import java.util.*;

public class Dijkstra {

    static final int INF = Integer.MAX_VALUE;

    static void dijkstra(int[][] graph, int source) {

        int n = graph.length;

        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        // Initially, all distances are infinity
        Arrays.fill(distance, INF);

        // Distance from source to itself is 0
        distance[source] = 0;

        // Find shortest distance for every vertex
        for (int count = 0; count < n - 1; count++) {

            int u = -1;
            int min = INF;

            // Find unvisited vertex with minimum distance
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }

            if (u == -1) {
                break;
            }

            visited[u] = true;

            // Update distances of adjacent vertices
            for (int v = 0; v < n; v++) {

                if (graph[u][v] != 0 &&
                    !visited[v] &&
                    distance[u] != INF &&
                    distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from vertex " + source + ":");

        for (int i = 0; i < n; i++) {
            System.out.println("0 -> " + i + " = " + distance[i]);
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 4, 1, 0},
            {4, 0, 0, 2},
            {1, 0, 0, 5},
            {0, 2, 5, 0}
        };

        dijkstra(graph, 0);
    }
}