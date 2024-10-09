import java.util.*;

class Day_25_BT_IS_BST {

    // Function to find the shortest path in an unweighted graph
    public int shortestPath(int V, List<int[]> edges, int start, int end) {
        // Create an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph (adjacency list) from the list of edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Perform BFS to find the shortest path
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, -1); // Initialize distances to -1 (not reachable)

        // Initialize BFS
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // If we reach the end node, return the distance
            if (node == end) {
                return distance[node];
            }

            // Explore neighbors
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // If there's no path from start to end
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices (V): ");
        int V = scanner.nextInt();

        // Input number of edges
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        // Input edges
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges (format: u v for each edge):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }

        // Input start and end nodes
        System.out.print("Enter the start node: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end node: ");
        int end = scanner.nextInt();

        // Check if the start or end nodes are within valid bounds
        if (start < 0 || start >= V || end < 0 || end >= V) {
            System.out.println("Invalid input: start or end node is out of bounds.");
            return;
        }

        // Create an instance of the solution class
        Day_25_BT_IS_BST sp = new Day_25_BT_IS_BST();

        // Output the shortest path length
        int result = sp.shortestPath(V, edges, start, end);
        if (result != -1) {
            System.out.println("Shortest Path Length: " + result);
        } else {
            System.out.println("No path exists between " + start + " and " + end);
        }
    }
}
