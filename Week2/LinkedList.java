public class LinkedList {
    private int data;
    private LinkedList next;
    private LinkedList previous;

    public LinkedList(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(9);
        LinkedList i2 = new LinkedList(9);

        head.next = i2;
        
        LinkedList i3 = new LinkedList(9);
        i2.next = i3;

    }
}
