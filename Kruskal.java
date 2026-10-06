import java.util.*;

public class Kruskal {

    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static int find(int[] parent, int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }

        return parent[vertex] = find(parent, parent[vertex]);
    }

    static void union(int[] parent, int[] rank, int a, int b) {

        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            }
            else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            }
            else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 4;

        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(1, 2, 2),
            new Edge(2, 3, 3),
            new Edge(0, 2, 4),
            new Edge(1, 3, 5)
        };

        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a.weight - b.weight);

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        // Initially, every vertex is its own parent
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgeCount = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        for (Edge edge : edges) {

            int rootSource = find(parent, edge.source);
            int rootDestination = find(parent, edge.destination);

            // If roots are different, no cycle is formed
            if (rootSource != rootDestination) {

                System.out.println(
                    edge.source + " - " +
                    edge.destination + " : " +
                    edge.weight
                );

                totalCost += edge.weight;
                edgeCount++;

                union(parent, rank, edge.source, edge.destination);

                if (edgeCount == vertices - 1) {
                    break;
                }
            }
        }

        System.out.println("Minimum Cost: " + totalCost);
    }
}