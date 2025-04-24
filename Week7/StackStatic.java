public class StackStatic {
    private int[] stack;
    private int top;
    private int capacity;

    public StackStatic(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack is full. Cannot push " + data);
            return;
        }
        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stack[top];
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackStatic stack = new StackStatic(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
        System.out.println("Popped: " + stack.pop());
        stack.printStack();
        System.out.println("Peek: " + stack.peek());
    }
}
