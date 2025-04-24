import java.util.TreeSet;

public class BSTDemo {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(0);
        tree.add(3);
        tree.add(1);
        tree.add(2);

        for(Object ele: tree.toArray()){
            System.out.println((Integer)ele);
        }
    }
}
