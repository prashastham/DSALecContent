import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class ListGraph extends Graph {

    ArrayList<ArrayList<Integer>> adjacency;
    
    public ListGraph(int s) {
        super(s);
        adjacency = new ArrayList<>(size);
        for(int i=0; i<size; i++)
            adjacency.add(new ArrayList<>());
    }
    
    @Override
    public void addEdge(int from, int to){
        adjacency.get(from).add(to);
    }
    
    @Override
    public String toString(){
        String adjList = "";
        for(int i=0; i<size; i++){
            adjList += i + ": ";
            for(int j: adjacency.get(i))
                adjList += j + " ";
            adjList += "\n";
        }
        return adjList;
    }
    
    @Override
    public void DFS(){
        boolean[] visited = new boolean[size];
        DFSTravel(0, visited);
        System.out.println();
    }

    public void DFSTravel(int startVertex, boolean[] visited){
        visited[startVertex] = true;
        System.out.print(startVertex + " ");
        for(int i = 0; i < size; i++){
            if(adjacency.get(startVertex).contains(i) && !visited[i]){
                DFSTravel(i, visited);
            }
        }
    }
	
    @Override
    public void BFS(){
	    boolean[] visited = new boolean[size];
        Queue<Integer> open = new LinkedList<>();

        open.add(0);
        visited[0] = true;

        while(!open.isEmpty()){
            int v = open.remove();
            System.out.print(v + " ");
            for(int i = 0; i < size; i++){
                if(adjacency.get(v).contains(i) && !visited[i]){
                    open.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    


}
