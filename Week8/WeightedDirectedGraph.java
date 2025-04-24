public class WeightedDirectedGraph {
    int vertexCount;
    int[][] adjMatrix;  

    public WeightedDirectedGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new int[vertexCount][vertexCount];

        // Initialize the adjacency matrix with zeros
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                adjMatrix[i][j] = -1;
            }
        }
    }

    public void addEdge(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = -1;
    }

    public boolean hasEdge(int i, int j) {
        return adjMatrix[i][j] > -1;
    }

    public int[] neighbors(int vertex) {
        int count = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[vertex][i] > 0) {
                count++;
            }
        }
        int[] neighbors = new int[count];
        int index = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[vertex][i] > 0) {
                neighbors[index] = i;
                index++;
            }
        }
        return neighbors;
    }

    public void printGraph() {
        // Print indexes
        System.out.print("  ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("  " + i);
        }
        System.out.println();
        // Print matrix
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + ":");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMatrix[i][j] == -1 ? " "+ adjMatrix[i][j]: "  " + adjMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedDirectedGraph graph = new WeightedDirectedGraph(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(2, 0, 7);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 5);
        graph.printGraph();
    }
}

