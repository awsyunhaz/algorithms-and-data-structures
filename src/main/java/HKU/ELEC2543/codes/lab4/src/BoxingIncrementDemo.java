public class BoxingIncrementDemo {

  public static void main(String[] args) {
    Integer obj1, obj2;
    int i, j;

    // Case I: obj1 = 100; obj2 = 101; obj1++;
    obj1 = 100;
    obj2 = 101;
    obj1++;
    System.out.println("Case I: obj1 = 100; obj2 = 101; obj1++;");
    if (obj1 == obj2) 
      System.out.println("obj1 == obj2");
    else 
      System.out.println("obj1 =/= obj2");


    // Case II: obj1 = 1000; obj2 = 1001; obj1++;
    obj1 = 1000;
    obj2 = 1001;
    obj1++;
    System.out.println("\nCase II: obj1 = 1000; obj2 = 1001; obj1++;");
    if (obj1 == obj2) 
      System.out.println("obj1 == obj2");
    else 
      System.out.println("obj1 =/= obj2");


    // Case III: obj1 = obj2 = 1000; obj1++; obj1--;
    obj1 = obj2 = 1000;
    obj1++; obj1--;
    System.out.println("\nCase III: obj1 = obj2 = 1000; obj1++; obj1--;");
    if (obj1 == obj2) 
      System.out.println("obj1 == obj2");
    else 
      System.out.println("obj1 =/= obj2");


    // Case IV: obj1 = 100; obj2 = new Integer(101); obj1++;
    obj1 = 100;
    obj2 = new Integer(101);
    obj1++;
    System.out.println("\nCase IV: obj1 = 100; obj2 = new Integer(101); obj1++;");
    if (obj1 == obj2) 
      System.out.println("obj1 == obj2");
    else 
      System.out.println("obj1 =/= obj2");
  }
}
