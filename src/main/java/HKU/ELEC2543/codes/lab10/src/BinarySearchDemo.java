public class BinarySearchDemo {

  public static void main(String args[]) {

    Integer[] arr = new Integer[7];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }

    System.out.println("arr[] contains elements 0, 1, 2, 3, 4, 5, and 6.");

    System.out.println("Binary Search Results are: ");

    for (int i = -2; i < arr.length+2; i++) {

	if (BinarySearch.search(arr, i) != null) 
	   System.out.println(i + " is in the array.");
	else
	   System.out.println(i + " is not in the array.");
    }
    
  }
}
