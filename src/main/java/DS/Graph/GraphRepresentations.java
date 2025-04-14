package DS.Graph;

import java.util.*;

public class GraphRepresentations {

    public static void main(String[] args) {
        // Example usage
        int vertices = 5;

        // Create a sample edge list for an undirected graph
        List<int[]> edgeList = new ArrayList<>();
        edgeList.add(new int[]{0, 1});
        edgeList.add(new int[]{0, 4});
        edgeList.add(new int[]{1, 2});
        edgeList.add(new int[]{1, 3});
        edgeList.add(new int[]{1, 4});
        edgeList.add(new int[]{2, 3});
        edgeList.add(new int[]{3, 4});

        // Create a sample weighted edge list
        List<int[]> weightedEdgeList = new ArrayList<>();
        weightedEdgeList.add(new int[]{0, 1, 5});
        weightedEdgeList.add(new int[]{0, 4, 2});
        weightedEdgeList.add(new int[]{1, 2, 4});
        weightedEdgeList.add(new int[]{1, 3, 7});
        weightedEdgeList.add(new int[]{1, 4, 6});
        weightedEdgeList.add(new int[]{2, 3, 3});
        weightedEdgeList.add(new int[]{3, 4, 1});

        // Convert to adjacency list
        List<List<Integer>> adjList = edgeListToAdjList(edgeList, vertices);

        // Convert to weighted adjacency list
        List<List<int[]>> weightedAdjList = weightedEdgeListToAdjList(weightedEdgeList, vertices);

        // Print representations
        System.out.println("Edge List:");
        printEdgeList(edgeList);

        System.out.println("\nAdjacency List:");
        printAdjList(adjList);

        System.out.println("\nWeighted Edge List:");
        printWeightedEdgeList(weightedEdgeList);

        System.out.println("\nWeighted Adjacency List:");
        printWeightedAdjList(weightedAdjList);

        // Example operations
        System.out.println("\n--- Operations with Edge List ---");

        // Find neighbors using edge list
        int node = 1;
        System.out.println("Neighbors of node " + node + " (using edge list):");
        printNeighborsUsingEdgeList(edgeList, node);

        // Check if edge exists using edge list
        int u = 1, v = 3;
        System.out.println("Edge (" + u + "," + v + ") exists? " + edgeExistsInEdgeList(edgeList, u, v));

        // BFS traversal using edge list
        System.out.println("\nBFS traversal using edge list starting from node 0:");
        bfsTraversalUsingEdgeList(edgeList, vertices, 0);

        // DFS traversal using edge list
        System.out.println("\nDFS traversal using edge list starting from node 0:");
        dfsTraversalUsingEdgeList(edgeList, vertices, 0);

        System.out.println("\n--- Operations with Adjacency List ---");

        // Find neighbors using adjacency list
        System.out.println("Neighbors of node " + node + " (using adjacency list):");
        printNeighborsUsingAdjList(adjList, node);

        // Check if edge exists using adjacency list
        System.out.println("Edge (" + u + "," + v + ") exists? " +
                edgeExistsInAdjList(adjList, u, v));

        // BFS traversal using adjacency list
        System.out.println("\nBFS traversal using adjacency list starting from node 0:");
        bfsTraversalUsingAdjList(adjList, 0);

        // DFS traversal using adjacency list
        System.out.println("\nDFS traversal using adjacency list starting from node 0:");
        dfsTraversalUsingAdjList(adjList, 0);

        // Dijkstra's algorithm with weighted adjacency list
        System.out.println("\nShortest distances from node 0 (Dijkstra's algorithm):");
        dijkstraShortestPath(weightedAdjList, 0);

        // Dijkstra's algorithm with weighted edge list
        System.out.println("\nShortest distances from node 0 (Dijkstra's algorithm using edge list):");
        dijkstraShortestPathUsingEdgeList(weightedEdgeList, vertices, 0);
    }

    // -------------------- Conversion Methods --------------------

    /**
     * Convert an edge list to an adjacency list for an undirected graph.
     * Time Complexity: O(E)
     * Space Complexity: O(V + E)
     */
    public static List<List<Integer>> edgeListToAdjList(List<int[]> edgeList, int vertices) {
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];

            // Add edges in both directions for an undirected graph
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Remove this line for directed graphs
        }

        return adjList;
    }

    /**
     * Convert a weighted edge list to a weighted adjacency list for an undirected graph.
     * Time Complexity: O(E)
     * Space Complexity: O(V + E)
     */
    public static List<List<int[]>> weightedEdgeListToAdjList(List<int[]> weightedEdgeList, int vertices) {
        List<List<int[]>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] edge : weightedEdgeList) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // Store [neighbor, weight]
            adjList.get(u).add(new int[]{v, weight});
            adjList.get(v).add(new int[]{u, weight}); // Remove this line for directed graphs
        }

        return adjList;
    }

    // -------------------- Operations with Edge List --------------------

    /**
     * Find and print all neighbors of a given node using an edge list.
     * Time Complexity: O(E) - must check all edges
     */
    public static void printNeighborsUsingEdgeList(List<int[]> edgeList, int node) {
        List<Integer> neighbors = new ArrayList<>();

        for (int[] edge : edgeList) {
            if (edge[0] == node) {
                neighbors.add(edge[1]);
            } else if (edge[1] == node) { // For undirected graphs
                neighbors.add(edge[0]);
            }
        }

        System.out.println(neighbors);
    }

    /**
     * Check if an edge exists in the edge list.
     * Time Complexity: O(E) - must check all edges in worst case
     */
    public static boolean edgeExistsInEdgeList(List<int[]> edgeList, int u, int v) {
        for (int[] edge : edgeList) {
            if ((edge[0] == u && edge[1] == v) || (edge[0] == v && edge[1] == u)) {
                return true;
            }
        }
        return false;
    }

    // -------------------- Operations with Adjacency List --------------------

    /**
     * Find and print all neighbors of a given node using an adjacency list.
     * Time Complexity: O(1) to access the list, O(degree) to process it
     */
    public static void printNeighborsUsingAdjList(List<List<Integer>> adjList, int node) {
        if (node >= 0 && node < adjList.size()) {
            System.out.println(adjList.get(node));
        } else {
            System.out.println("Node out of range");
        }
    }

    /**
     * Check if an edge exists in the adjacency list.
     * Time Complexity: O(degree of u) - only need to check neighbors of u
     */
    public static boolean edgeExistsInAdjList(List<List<Integer>> adjList, int u, int v) {
        if (u < 0 || u >= adjList.size() || v < 0 || v >= adjList.size()) {
            return false;
        }
        return adjList.get(u).contains(v);
    }

    /**
     * BFS traversal of a graph represented as an edge list.
     * Time Complexity: O(V * E) - For each vertex, we need to scan all edges to find neighbors
     * Space Complexity: O(V) - For the queue and visited array
     */
    public static void bfsTraversalUsingEdgeList(List<int[]> edgeList, int vertices, int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        List<Integer> traversal = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            traversal.add(node);

            // Find all neighbors - requires scanning the entire edge list for each vertex
            for (int[] edge : edgeList) {
                int nextNode = -1;

                if (edge[0] == node && !visited[edge[1]]) {
                    nextNode = edge[1];
                } else if (edge[1] == node && !visited[edge[0]]) { // For undirected graphs
                    nextNode = edge[0];
                }

                if (nextNode != -1 && !visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }

        System.out.println(traversal);
    }

    /**
     * DFS traversal of a graph represented as an edge list.
     * Time Complexity: O(V * E) - For each vertex, we need to scan all edges to find neighbors
     * Space Complexity: O(V) - For the recursion stack and visited array
     */
    public static void dfsTraversalUsingEdgeList(List<int[]> edgeList, int vertices, int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> traversal = new ArrayList<>();

        dfsHelperUsingEdgeList(edgeList, vertices, start, visited, traversal);

        System.out.println(traversal);
    }

    private static void dfsHelperUsingEdgeList(List<int[]> edgeList, int vertices, int node, boolean[] visited, List<Integer> traversal) {
        visited[node] = true;
        traversal.add(node);

        // Find all unvisited neighbors by scanning the entire edge list
        for (int[] edge : edgeList) {
            int nextNode = -1;

            if (edge[0] == node && !visited[edge[1]]) {
                nextNode = edge[1];
            } else if (edge[1] == node && !visited[edge[0]]) { // For undirected graphs
                nextNode = edge[0];
            }

            if (nextNode != -1 && !visited[nextNode]) {
                dfsHelperUsingEdgeList(edgeList, vertices, nextNode, visited, traversal);
            }
        }
    }

    /**
     * BFS traversal of a graph represented as an adjacency list.
     * Time Complexity: O(V + E) - We process each vertex and edge once
     * Space Complexity: O(V) - For the queue and visited array
     */
    public static void bfsTraversalUsingAdjList(List<List<Integer>> adjList, int start) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        List<Integer> traversal = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            traversal.add(node);

            // O(1) access to neighbors
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println(traversal);
    }

    /**
     * DFS traversal of a graph represented as an adjacency list.
     * Time Complexity: O(V + E) - We process each vertex and edge once
     * Space Complexity: O(V) - For the recursion stack and visited array
     */
    public static void dfsTraversalUsingAdjList(List<List<Integer>> adjList, int start) {
        boolean[] visited = new boolean[adjList.size()];
        List<Integer> traversal = new ArrayList<>();

        dfsHelperUsingAdjList(adjList, start, visited, traversal);

        System.out.println(traversal);
    }

    private static void dfsHelperUsingAdjList(List<List<Integer>> adjList, int node,
            boolean[] visited, List<Integer> traversal) {
        visited[node] = true;
        traversal.add(node);

        // O(1) access to neighbors
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfsHelperUsingAdjList(adjList, neighbor, visited, traversal);
            }
        }
    }

    /**
     * Dijkstra's algorithm for finding shortest paths using a weighted adjacency list.
     * Time Complexity: O((V + E) log V) with priority queue
     * Space Complexity : O(V)
     */
    public static void dijkstraShortestPath(List<List<int[]>> weightedAdjList, int start) {
        int n = weightedAdjList.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // Min-heap priority queue: [node, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            // Skip if we've found a better path already
            if (distance > distances[node]) {
                continue;
            }

            // Process all neighbors
            for (int[] edge : weightedAdjList.get(node)) {
                int neighbor = edge[0];
                int weight = edge[1];

                // Relaxation step
                if (distances[node] + weight < distances[neighbor]) {
                    distances[neighbor] = distances[node] + weight;
                    pq.offer(new int[]{neighbor, distances[neighbor]});
                }
            }
        }

        // Print distances
        for (int i = 0; i < n; i++) {
            System.out.println("Distance to node " + i + ": " +
                    (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
        }
    }

    /**
     * Dijkstra's algorithm for finding shortest paths using a weighted edge list.
     * Time Complexity: O(V * E + V^2) - We check all edges for each vertex + priority queue operations
     * Space Complexity: O(V) - For distances array and priority queue
     */
    public static void dijkstraShortestPathUsingEdgeList(List<int[]> weightedEdgeList, int vertices, int start) {
        // Initialize distances array
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // Visited set to track processed vertices
        boolean[] visited = new boolean[vertices];

        // Process vertices
        for (int i = 0; i < vertices; i++) {
            // Find the unvisited vertex with minimum distance
            int minVertex = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && distances[v] < minDistance) {
                    minVertex = v;
                    minDistance = distances[v];
                }
            }

            // If we can't find a valid vertex, break
            if (minVertex == -1) break;

            // Mark the vertex as visited
            visited[minVertex] = true;

            // Scan all edges to find neighbors and update distances
            for (int[] edge : weightedEdgeList) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                // Process edge from minVertex to v
                if (u == minVertex && !visited[v]) {
                    if (distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;
                    }
                }
                // For undirected graphs, also process edge from v to minVertex
                else if (v == minVertex && !visited[u]) {
                    if (distances[v] + weight < distances[u]) {
                        distances[u] = distances[v] + weight;
                    }
                }
            }
        }

        // Print distances
        for (int i = 0; i < vertices; i++) {
            System.out.println("Distance to node " + i + ": " +
                    (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
        }
    }

    // -------------------- Print Methods --------------------

    public static void printEdgeList(List<int[]> edgeList) {
        for (int[] edge : edgeList) {
            System.out.println("(" + edge[0] + ", " + edge[1] + ")");
        }
    }

    public static void printWeightedEdgeList(List<int[]> weightedEdgeList) {
        for (int[] edge : weightedEdgeList) {
            System.out.println("(" + edge[0] + ", " + edge[1] + ", weight: " + edge[2] + ")");
        }
    }

    public static void printAdjList(List<List<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            System.out.println(adjList.get(i));
        }
    }

    public static void printWeightedAdjList(List<List<int[]>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int[] edge : adjList.get(i)) {
                System.out.print("(" + edge[0] + ", weight: " + edge[1] + ") ");
            }
            System.out.println();
        }
    }
}

/**
 * Here's a summary of the key differences:
 * BFS Traversal
 * Edge List Implementation:
 *
 * Time Complexity: O(V * E) - For each vertex, we must scan the entire edge list to find neighbors
 * Space Complexity: O(V) - For the queue and visited array
 *
 * Adjacency List Implementation:
 * Time Complexity: O(V + E) - We process each vertex and edge exactly once
 * Space Complexity: O(V) - For the queue and visited array
 *
 *
 *
 *
 * DFS Traversal
 * Edge List Implementation:
 *
 * Time Complexity: O(V * E) - For each vertex, we must scan the entire edge list to find neighbors
 * Space Complexity: O(V) - For the recursion stack and visited array
 *
 *
 * Adjacency List Implementation:
 *
 * Time Complexity: O(V + E) - We process each vertex and edge exactly once
 * Space Complexity: O(V) - For the recursion stack and visited array
 *
 * Key Observations
 *
 * Performance Gap: The edge list implementations are significantly slower (O(V*E) vs O(V+E)) because:
 *
 * For each vertex, we must scan the entire edge list to find its neighbors
 * This creates an additional O(E) factor in the time complexity
 *
 *
 * Same Space Usage: Both representations use O(V) space for the queue/stack and visited array
 * Edge List Inefficiency: The edge list implementation highlights why we typically convert to adjacency lists for traversals - the constant need to scan the entire edge list for neighbors creates a major performance bottleneck.
 *
 * The implementations clearly demonstrate why adjacency lists are strongly preferred for graph traversal algorithms, as the O(V*E) vs O(V+E) difference is substantial for large graphs.
 */