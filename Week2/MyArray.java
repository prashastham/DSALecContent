import java.util.Arrays;

public class MyArray {
    private int[] arr;

    //Constructor size
    public MyArray(int size) {
        this.arr = new int[size];
        Arrays.setAll(this.arr, i -> i + 1);
    }

    //Reading at any given index
    public int get(int idx) {
        return this.arr[idx];
    }
    
    //Writing at any given index
    public void set(int idx, int value) {
        this.arr[idx] = value;
    }

    //Adding at the end
    public void add(int value) {
        int[] newArray = new int[this.arr.length + 1];
        System.arraycopy(arr, 0, newArray, 0, this.arr.length);
        newArray[this.arr.length] = value;
        this.arr = newArray;
    }

    //Adding at any given index
    public void add(int idx, int value) {
        int[] newArray = new int[this.arr.length + 1];
        System.arraycopy(arr, 0, newArray, 0, idx);
        newArray[idx] = value;
        System.arraycopy(arr, idx, newArray, idx + 1, arr.length - idx);
        this.arr = newArray;
    }

    //Removing given the index
    public void remove(int idx) {
        if(this.arr.length != 0){
            int[] newArray = new int[this.arr.length - 1];
            System.arraycopy(arr, 0, newArray, 0, idx);
            System.arraycopy(arr, idx + 1, newArray, idx, arr.length - idx - 1);
            this.arr = newArray;
        }
    }

    //Find the index of given value (linear search)
    public int indexOf(int value) {
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //Get the size of array
    public int size() {
        return this.arr.length;
    }

    //Check if array is empty
    public boolean isEmpty() {
        return this.arr.length == 0;
    }

    //Print elements
    public void print() {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
       MyArray numbers = new MyArray(5);
       numbers.print();
       numbers.set(0, 10);
       numbers.print();
       numbers.set(4, 15);
       numbers.print();
       numbers.remove(3);
       numbers.print();
       numbers.add(2, 100);
       numbers.print();
       System.err.println("Index of 100: "+numbers.indexOf(100));

    }
}
