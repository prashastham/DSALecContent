class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackDynamic {
    Node stack_top;
    int size;

    public StackDynamic(){
        stack_top = null;
        size = 0;
    }

    public void push(int data){
        Node newNode = new Node(data);
        // If stack is empty, set newNode as stack_top
        if(stack_top == null){
            stack_top = newNode;
        }
        else{
            // Set newNode as stack_top and set newNode's next as stack_top
            Node stack = stack_top;
            stack_top = newNode;
            newNode.next = stack;
        }
        size++;
    }

    public int pop(){
        // If stack is empty, return -1
        if(stack_top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            // Set stack_top as stack_top's next and return stack_top's data
            int data = stack_top.data;
            stack_top = stack_top.next;
            size--;
            return data;
        }
    }

    public int peek(){
        if(stack_top == null){
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            return stack_top.data;
        }
    }

    public void printStack(){
        if(stack_top == null){
            System.out.println("Stack is empty");
        }
        else{
            Node current = stack_top;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args){
        StackDynamic stack = new StackDynamic();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack();
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.getSize());
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
    }
}
