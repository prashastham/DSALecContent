import java.util.LinkedList;
import java.util.Queue;

public class MatrixGraph extends Graph {

    boolean[][] adjacencyMatrix;
    
    public MatrixGraph(int s) {
        super(s);
        adjacencyMatrix = new boolean[size][size];
    }
    
    @Override
    public void addEdge(int from, int to){
        adjacencyMatrix[from][to] = true;
    }
    
    @Override
    public String toString(){
        String adjMatrix = "";
        for(boolean[] i: adjacencyMatrix){
            for(boolean j: i){
                adjMatrix += j ? "T ":"F ";
            }
            adjMatrix += "\n";
        }
        return adjMatrix;
    }
    
    @Override
    public void DFS(){
        boolean[] visited = new boolean[size];
        DFSTravel(0, visited);
        System.out.println();
    }
    // Recursive part
    private void DFSTravel(int startVertex, boolean[] visited){
        visited[startVertex] = true;
        System.out.print(startVertex + " ");
        for(int i = 0; i < adjacencyMatrix.length; i++){
            if(adjacencyMatrix[startVertex][i] && !visited[i]){
                DFSTravel(i, visited);
            }

        }

    }
	
    @Override
    public void BFS(){
        //closed list
	    boolean[] visited = new boolean[size];
        //open list
        Queue<Integer> open = new LinkedList<>();
        //adding 0 to open list
        open.add(0);
        visited[0] = true;

        while(!open.isEmpty()){
            int v = open.poll();
            System.out.print(v + " ");
            for(int i = 0; i < adjacencyMatrix.length; i++){
                if(adjacencyMatrix[v][i] && !visited[i]){
                    open.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
