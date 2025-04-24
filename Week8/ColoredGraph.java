import java.util.ArrayList;

public class ColoredGraph {
    // A directed graph with colored edges
    
    class Vertex{
        int value;
        int color;
        public Vertex(int value, int color){
            this.value = value;
            this.color = color;
        }
    }

    int vertexCount;
    ArrayList<ArrayList<Vertex>> adjList;
    
    public ColoredGraph(int vertexCount){
        this.vertexCount = vertexCount;
        adjList = new ArrayList<>(vertexCount);
        for(int i = 0; i < vertexCount; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int i, int j, int color){
        adjList.get(i).add(new Vertex(j, color));
    }

    public void printGraph(){
        for(int i = 0; i < vertexCount; i++){
            System.out.print(i + ": ");
            for(Vertex v : adjList.get(i)){
                System.out.print("(" + v.value + ", " + v.color + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ColoredGraph graph = new ColoredGraph(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 4);
        graph.printGraph();
    }   
}
