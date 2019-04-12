public class PascalTriangle {

  // YOU MUST USE RECURSION TO IMPLEMENT THIS METHOD
  public static int[] computePT(int k) {

    int[] arr = new int[k];
    arr[0] = 1; arr[k-1] = 1;
    int[] arrUp = new int[k-1];
    if (k>1)
    	arrUp = computePT(k-1);
    for (int i = 1; i < k-1; i++){
    	arr[i] = arrUp[i-1] + arrUp[i];
    }
    
    return arr;
  }

  public static void main(String args[]) {

    int k = 5;

    int arr[] = computePT(k);

    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");

    System.out.println();
  }
}
