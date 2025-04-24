public class DirectedGraph {
    int vertexCount;
    int[][] adjMatrix;

    public DirectedGraph(int vertexCount) {
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
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
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

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.printGraph();
    }

}
