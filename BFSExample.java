import java.util.*;

class BFSExample {
    // Graph represented using adjacency list
    private Map<Integer, List<Integer>> adjList;

    // Constructor
    public BFSExample() {
        adjList = new HashMap<>();
    }

    // Add edge (undirected graph)
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // remove this line if graph is directed
    }

    // BFS Traversal
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BFSExample graph = new BFSExample();

        // Example graph
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);

        // Perform BFS starting from node 1
        graph.bfs(1);
    }
}
