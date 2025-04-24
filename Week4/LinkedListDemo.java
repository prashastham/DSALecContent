import java.util.LinkedList;

public class LinkedListDemo {
    public static void printList(LinkedList<Integer> list){
        for(Integer item: list){
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        printList(list);
        list.add(3);
        printList(list);
        list.add(1, 2);
        printList(list);
        list.add(1, 1);
        printList(list);

        list.remove(1);
        printList(list);
        list.remove(1);
        printList(list);
    }    
}
