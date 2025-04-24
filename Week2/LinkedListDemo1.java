import java.util.LinkedList;

public class LinkedListDemo1 {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println(numbers);

        numbers.addFirst(0);
        numbers.addLast(6);
        System.out.println(numbers);

        numbers.remove(3);
        System.out.println(numbers);

        numbers.removeFirst();
        numbers.removeLast();
        System.out.println(numbers);

        
    }
}
