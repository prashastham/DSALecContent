public class QueueStatic {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueStatic(int size) {
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear++;
        queue[rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int item = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return item;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueStatic queue = new QueueStatic(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
    }
}
