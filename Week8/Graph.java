
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int vertexCount;
    int[][] adjMatrix;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new int[vertexCount][vertexCount];

        // Initialize the adjacency matrix with zeros
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public boolean hasEdge(int i, int j) {
        return adjMatrix[i][j] == 1;
    }

    public int[] neighbors(int vertex) {
        int count = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[vertex][i] == 1) {
                count++;
            }
        }
        int[] neighbors = new int[count];
        int index = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[vertex][i] == 1) {
                neighbors[index] = i;
                index++;
            }
        }
        return neighbors;
    }

    public void printGraph() {
        // Print indexes
        System.err.print("   ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // Print matrix
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // DFS traversal -- recursive
    public void printDFS(int startVertex) {
        System.out.println("\nDeapth-first traversal from vertex " + startVertex + ": ");
        boolean[] visited = new boolean[vertexCount];
        DFS(adjMatrix, startVertex, visited);
        System.out.println();
    }

    private static void DFS(int[][] adjMatrix, int startVertex, boolean[] visited) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");
        for (int i = 0; i < adjMatrix.length; i++) {
            // If an edge exists and the vertex is not visited, recursively call DFS on it
            if (adjMatrix[startVertex][i] == 1 && !visited[i]) {
                System.out.println("Call DFS(" + i + ")");
                DFS(adjMatrix, i, visited);
                System.out.println("Return from DFS(" + i + ")");
            }
        }

    }

    // BFS traversal -- iterative
    public void printBFS(int startVertex) {
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            // Print queue
            System.out.print("Queue: ");
            for (int i = 0; i < queue.size(); i++) {
                System.out.print(queue.toArray()[i] + " ");
            }
            System.out.println();
            // End of print queue
            for (int i = 0; i < vertexCount; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
       
        graph.printGraph();

        //graph.printDFS(0);
        graph.printBFS(0);
    }
}
