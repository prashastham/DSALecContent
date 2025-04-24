class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class QueueDynamic {
    Node queue;
    Node front;
    Node rear;
    
    public QueueDynamic(){
        this.queue = null;
        this.front = null;
        this.rear = null;
    }
    
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(queue == null){
            queue = newNode;
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue(){
        if(queue == null){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int data = front.data;
            front = front.next;
            return data;
        }
    }

    public void printQueue(){
        if(queue == null){
            System.out.println("Queue is empty");
        }
        else{
            Node current = front;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueDynamic queue = new QueueDynamic();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
    }
}
