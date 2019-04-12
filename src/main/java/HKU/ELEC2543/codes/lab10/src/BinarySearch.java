public class BinarySearch {

  // find target from list[i] to list[j]
  // return null if target not found
  //  YOU MUST USE RECURSION TO IMPLEMENT THIS METHOD
  public static Comparable binSearch(int i, int j, Comparable[] list, Comparable target) {
	  if (i == j && target.compareTo(list[i])!=0)
		  return null;
	  else{
		  int mid = (i+j)/2;
		  if (target.compareTo(list[mid]) == 0)
			  return list[mid];
		  else if (target.compareTo(list[mid]) == -1)
			  return binSearch(0,mid-1,list,target);
		  else
			  return binSearch(mid+1,j,list,target);
	  }
  }


  // find target from list[]
  // return null if target not found
  public static Comparable search(Comparable[] list, Comparable target) {

    // search the item using method binSearch
    return binSearch(0, list.length-1, list, target);
  }
}
