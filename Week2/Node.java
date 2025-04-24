public class Node {
    private final int data;
    private Node next;
    private Node previous;
    
    // Constructor
    public Node(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    
    public void traverse(){
        Node current = this;
        System.out.print("Start -> ");
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(" End.");
    }
    
    public void search(int target){
        Node current = this;
        while((current != null) && (current.data != target))
            current = current.next;
        if(current != null){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        Node n1 = new Node(4);
        Node n2 = new Node(8);
        head.next = n1;
        n1.previous = head;
        n1.next = n2;
        n2.previous = n1;
        
        head.traverse();
        head.search(4);
        head.search(6);
    }
}
