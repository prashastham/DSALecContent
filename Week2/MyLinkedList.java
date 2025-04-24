
public class MyLinkedList{
    Node first;
    Node last;

    MyLinkedList (int val) {
        first = new Node(val);
        last = first;
        last.next = null;
    }

    public void add(int val){
        last.next = new Node(val);
        Node temp = last;
        last = last.next;
        last.previous = temp;
    }
    
    
    static class Node{
        int data;
        Node next;
        Node previous;

        //Constructor
        Node (int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void printList(){
        Node current = first;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int linearSearch(int target){
        Node current = first;
        int pos = 0;
        while(current != null){
            if(current.data == target){
                System.out.println("Target found at position " + pos);
                return pos;
            }
            current = current.next;
            pos++;
        }
        System.err.println("Target not found");
        return -1;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(1);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(4);

        list.printList();
        list.linearSearch(3);

    }
}

