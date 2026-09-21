import java.util.*;

public class DFS {

    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {

        // Mark node as visited
        visited[node] = true;

        // Print node
        System.out.print(node + " ");

        // Visit all adjacent nodes
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, visited, graph);
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Create graph
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);

        graph.get(3).add(1);

        graph.get(4).add(1);

        // Visited array
        boolean[] visited = new boolean[vertices];

        System.out.println("DFS Traversal:");

        dfs(0, visited, graph);
    }
}