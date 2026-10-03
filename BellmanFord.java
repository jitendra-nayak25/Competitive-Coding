import java.util.Arrays;

public class BellmanFord {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void bellmanFord(int vertices, Edge[] edges, int source) {

        int[] dist = new int[vertices];

        // Initially, all distances are infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance from source to itself is 0
        dist[source] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < vertices; i++) {

            for (Edge e : edges) {

                if (dist[e.src] != Integer.MAX_VALUE &&
                    dist[e.src] + e.weight < dist[e.dest]) {

                    dist[e.dest] = dist[e.src] + e.weight;
                }
            }
        }

        // Check for negative weight cycle
        for (Edge e : edges) {

            if (dist[e.src] != Integer.MAX_VALUE &&
                dist[e.src] + e.weight < dist[e.dest]) {

                System.out.println("Negative weight cycle detected");
                return;
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + source + ":");

        for (int i = 0; i < vertices; i++) {
            System.out.println(source + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int vertices = 4;

        Edge[] edges = {
            new Edge(0, 1, 4),
            new Edge(0, 2, 5),
            new Edge(1, 2, -2),
            new Edge(1, 3, 6),
            new Edge(2, 3, 3)
        };

        bellmanFord(vertices, edges, 0);
    }
}