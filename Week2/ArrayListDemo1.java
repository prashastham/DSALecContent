import java.util.ArrayList;

public class ArrayListDemo1 {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(4);
    numbers.add(9);
    numbers.add(16);
    System.out.println(numbers);
    
    numbers.remove(2);
    System.out.println(numbers);

    numbers.set(2, 5);
    System.out.println(numbers);

    numbers.add(2, 10);
    System.out.println(numbers);

    // for (int i = 0; i < numbers.size(); i++) {
    //   System.out.println(numbers.get(i));
    // }

    for (int i : numbers) {
      System.out.println(i);
    }
  }
}