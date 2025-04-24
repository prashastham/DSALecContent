import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ListGraph {
	
    int size;
    ArrayList<ArrayList<Integer>> adjacency;
    
    public ListGraph(int s){
	size = s;
        adjacency = new ArrayList<>(size);
        for(int i=0; i<size; i++)
            adjacency.add(new ArrayList<>());
    }

    public void addEdge(int from, int to){
        adjacency.get(from).add(to);
    }
    
    public void removeEdge(int from, int to){
        adjacency.get(from).remove(to);
    }
    
    public void addEdgesFromFile(Scanner s){
        while(s.hasNextInt())
            addEdge(s.nextInt(), s.nextInt());
    }

    private void printPath(int i, HashMap<Integer, Integer> predecessor) {
        System.out.print(i);
        if(predecessor.containsKey(i))
            while(i > 0){
                i = predecessor.get(i);
                System.out.print(" <- " + i);
            }
        else System.out.print(" is not reachable");
        System.out.println("");
    }

    
    public void BFS(){
	LinkedList<Integer> open = new LinkedList<>();
        HashMap<Integer, Integer> closed = new HashMap<>();
        HashMap<Integer, Integer> predecessor = new HashMap<>();
        open.addLast(0);
        closed.put(0, 0);
        predecessor.put(0, -1);
        while(!open.isEmpty()){
            int i = open.removeFirst();
            for(int j : adjacency.get(i))
                if(!closed.containsKey(j)){
                    open.addLast(j);
                    closed.put(j, 1 + closed.get(i));
                    predecessor.put(j,i);
                }
        }
        System.out.println("Shortest paths:");
        for(int i = 0; i < size; i++)
            printPath(i, predecessor);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = null;
        try{
            s = new Scanner(new File("example1.txt"));
        }
        catch(Exception e){
            System.out.println("Failed to open input file");
        }
        ListGraph g = new ListGraph(s.nextInt());
        g.addEdgesFromFile(s);
        g.BFS();
    }

}
