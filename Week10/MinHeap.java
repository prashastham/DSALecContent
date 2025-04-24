import java.util.ArrayList;
import java.util.HashMap;

public class MinHeap {
  ArrayList<WrappedVertex> items;
  
  public MinHeap() {
    items = new ArrayList<>();
  }

  public void insert(Vertex v, int d){
    items.add(new WrappedVertex(v, d));
    int index = items.size()-1;

    // Determine position of insertion
    while (index > 0){ // sift up
        int parent = (index - 1) / 2;
        if(items.get(parent).distance > items.get(index).distance){
            items.set(index, items.get(parent));
            index = parent;
        }
        else{
            break;
        }
    }
    items.set(index, new WrappedVertex(v, d));
  }

  public WrappedVertex extractMin(){
    WrappedVertex min = items.get(0);
    WrappedVertex last = items.remove(items.size() - 1);
    if(!items.isEmpty()){
        items.set(0, last);
        int index = 0;
        while(index < items.size()){ // sift down
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            if(left < items.size() && items.get(left).distance < items.get(smallest).distance){
                smallest = left;
            }
            if(right < items.size() && items.get(right).distance < items.get(smallest).distance){
                smallest = right;
            }
            if(smallest != index){
                items.set(index, items.get(smallest));
                index = smallest;
            }
            else{
                break;
            }
        }
        items.set(index, last);
    }
    return min;
  }

  public static void Dijkstra(Vertex source) {
    // open, closed and predecessor list
    // open = min heap
    MinHeap o = new MinHeap();
    // closed = hashmap (vertex, min distance from source)
    HashMap<Vertex, Integer> c = new HashMap<>();
    // predecessor = hashmap (vertex, nearest predecessor)
    HashMap<Vertex, Vertex> p = new HashMap<>();
    // initialize
    o.insert(source, 0);
    c.put(source, 0);
    p.put(source, null);
    System.out.println("Source node: " + source.id);
    
    // Dijkstra
    while (!o.items.isEmpty()) {
      WrappedVertex w = o.extractMin();
      //Check whether the current vertex we're processing 
      //has the most up-to-date (shortest) distance from the source.
      if(w.distance == c.get(w.vertex)){
        /*
        Output the distance and shortest path (follow the chain of predecessors)
            For every edge e out of w.vertex,
            - check if e gives a new shortest path to its target
            - update lists if yes
        */
        for (Vertex v: w.vertex.adjList.keySet()) {
          int newDistance = w.distance + w.vertex.getWeight(v);
          if(!c.containsKey(v) || newDistance < c.get(v)){
            c.put(v, newDistance);
            p.put(v, w.vertex);
            o.insert(v, newDistance);
          }
        }
        c.put(w.vertex, w.distance);
        // print out the minimum distance
        System.out.println("Min distance to node " + w.vertex.id + " from src: " + w.distance);
        // print out the shortest path
        System.out.print("Shortest Path: ");
        Vertex v = w.vertex;
        while (v != null) {
          System.out.print(v.id + " ");
          v = p.get(v);
        }
        System.out.println();
      }
    }
  }

  public static void main(String args[]){
    Vertex v1 = new Vertex(1);
    Vertex v2 = new Vertex(2);
    Vertex v3 = new Vertex(3);
    Vertex v4 = new Vertex(4);
    Vertex v5 = new Vertex(5);

    v1.addEdge(v2, 1);
    v1.addEdge(v3, 2);
    v1.addEdge(v4, 4);
    v2.addEdge(v4, 1);
    v3.addEdge(v4, 1);
    v2.addEdge(v5, 3);
    v4.addEdge(v5, 2);

    Dijkstra(v1);
  }

}
