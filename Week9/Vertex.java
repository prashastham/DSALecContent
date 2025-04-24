import java.util.HashMap;

public class Vertex {
    public int id;
    //<Connected Vertex, Weight>
    public HashMap<Vertex, Integer> adjList;

    public Vertex(int id) {
        this.id = id;
        this.adjList = new HashMap<>();
    }

    public void addEdge(Vertex v, int weight) {
        // target vertex, weight
        adjList.put(v, weight);
    }

    public void removeEdge(Vertex v) {
        adjList.remove(v);
    }

    public int getWeight(Vertex v) {
        return adjList.get(v);
    }

    public int getId() {
        return id;
    }
}
