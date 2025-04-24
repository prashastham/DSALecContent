import java.util.Arrays;

class ArrayDemo2 {
  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static int[] appendToArray(int[] arr, int value) {
    int[] newArray = new int[arr.length + 1];
    // for (int i = 0; i < arr.length; i++) {
    //   newArray[i] = arr[i];
    // }
    System.arraycopy(arr, 0, newArray, 0, arr.length);
    newArray[arr.length] = value;
    return newArray;
  }

  public static int[] deleteFromArray(int[] arr, int index) {
    int[] newArray = new int[arr.length - 1];
    System.arraycopy(arr, 0, newArray, 0, index);
    System.arraycopy(arr, index + 1, newArray, index, arr.length - index - 1);
    return newArray;
      
  }

  public static int[] addInMiddle(int[] arr, int value, int index) {
    int[] newArray = new int[arr.length + 1];
    System.arraycopy(arr, 0, newArray, 0, index);
    newArray[index] = value;
    System.arraycopy(arr, index, newArray, index + 1, arr.length - index);
    return newArray;
  }

  public static int linearSearch(int[] arr, int value) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] myArray = new int[7];
    Arrays.setAll(myArray, i -> i + 1); 

  }
}