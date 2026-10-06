public class Prim {

    public static void main(String[] args) {

        int[][] graph = {
            {0, 1, 4, 5},
            {1, 0, 0, 2},
            {4, 0, 0, 3},
            {5, 2, 3, 0}
        };

        int vertices = graph.length;

        boolean[] visited = new boolean[vertices];

        int[] key = new int[vertices];

        int[] parent = new int[vertices];

        // Initialize key values
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        // Start from vertex 0
        key[0] = 0;

        for (int count = 0; count < vertices - 1; count++) {

            int min = Integer.MAX_VALUE;
            int current = -1;

            // Find vertex with minimum key
            for (int v = 0; v < vertices; v++) {

                if (!visited[v] && key[v] < min) {
                    min = key[v];
                    current = v;
                }
            }

            visited[current] = true;

            // Update adjacent vertices
            for (int v = 0; v < vertices; v++) {

                if (graph[current][v] != 0 &&
                    !visited[v] &&
                    graph[current][v] < key[v]) {

                    key[v] = graph[current][v];
                    parent[v] = current;
                }
            }
        }

        // Print MST
        int totalCost = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        for (int i = 1; i < vertices; i++) {

            System.out.println(
                parent[i] + " - " + i +
                " : " + graph[i][parent[i]]
            );

            totalCost += graph[i][parent[i]];
        }

        System.out.println("Minimum Cost: " + totalCost);
    }
}