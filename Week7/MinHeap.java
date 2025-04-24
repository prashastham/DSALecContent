public class MinHeap {
    int[] items;
    public static final int INITIAL_CAPACITY = 1000;
    int size;

    public MinHeap() {
        items = new int[INITIAL_CAPACITY];
        size = 0; // Start size at 0 
    }
    
    public void insert(int newItem) {
        // Add new item at the end
        items[size] = newItem;
        // Sift up the new item
        siftUp(size);
        size++;
    }

    private void siftUp(int index) {
        int parent = (index - 1) / 2;
        // While we haven't reached the root and parent is greater than child
        while (index > 0 && items[parent] > items[index]) {
            // Swap parent and child
            int temp = items[parent];
            items[parent] = items[index];
            items[index] = temp;
            // Move up the heap
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    public int removeMin() {
        int min = items[0];
        items[0] = items[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    private void siftDown(int index) {
        int child = 2 * index + 1;
        // While we haven't reached the end of the heap
        while (child < size) {
            // Find the minimum child
            if (child + 1 < size && items[child] > items[child + 1]) {
                child++;
            }
            // If the child is greater than the parent, we're done
            if (items[index] <= items[child]) {
                break;
            }
            // Swap parent and child
            int temp = items[index];
            items[index] = items[child];
            items[child] = temp;
            // Move down the heap
            index = child;
            child = 2 * index + 1;
        }
    }

    public void printMinHeap() {
        for(int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] dataList = {10, 5, 2, 8, 1, 6, 3, 7, 4, 9};
        MinHeap heap = new MinHeap();
        for(int i = 0; i < dataList.length; i++) {
            heap.insert(dataList[i]);
            heap.printMinHeap();
        }
        heap.printMinHeap();
    }
}
