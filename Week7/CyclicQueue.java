public class CyclicQueue {

    private int[] queue;
    private int front;
    private int rear;
    final private int size;

    public CyclicQueue(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = item;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        int item = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        System.out.println("Dequeued: " + item);
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CyclicQueue queue = new CyclicQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // This should print an error message
        queue.printQueue();
    }

}
