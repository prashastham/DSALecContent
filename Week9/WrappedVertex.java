public class WrappedVertex {
    public Vertex vertex;
    // shotest path distance from source vertex
    public int distance;

    public WrappedVertex(Vertex vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}
