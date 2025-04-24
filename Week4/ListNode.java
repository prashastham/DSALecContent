public class ListNode {
    private int data;
    private ListNode next;
    private ListNode previous;
    
    // Constructor
    public ListNode(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    
    // Setters and Getters
    public void setData(int newData){
        this.data = newData;
    }
    public int getData(){
        return this.data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public void setPrevious(ListNode previous){
        this.previous = previous;
    }

    public ListNode getNext(){
        return this.next;
    }

    public ListNode getPrevious(){
        return this.previous;
    }

    // Print the list
    public void printList(){
        ListNode current = this;
        while(current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    // Insert a new node after the current node
    public void insertAfter(int newData, ListNode node){
        ListNode newNode = new ListNode(newData), next = node.getNext(); 
        newNode.setNext(node.getNext()); 
        newNode.setPrevious(node);
        node.setNext(newNode);
        if(next != null) 
            next.setPrevious(newNode);

    }

    // Delete a node
    public void remove(ListNode node){
        ListNode next = node.getNext(), previous = node.getPrevious();
        if(next != null){
            next.setPrevious(previous);
        }
        if(previous != null){
            previous.setNext(next);
        }
        node.next = null;
        node.previous = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.printList();
        head.insertAfter(3, head);
        head.printList();
        head.insertAfter(2, head);
        head.printList();
        head.insertAfter(1, head);
        head.printList();

        head.remove(head.getNext());
        head.printList();
        head.remove(head.getNext());
        head.printList();
    }

}
