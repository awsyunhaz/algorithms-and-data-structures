public class BoxingDemo {

  public static void main(String[] args) {
    Integer obj1, obj2;

    // Case I: obj1 = 1000; obj2 = 1000; 

    obj1 = 1000;
    obj2 = 1000;
    System.out.println("Case I: obj1 = 1000; obj2 = 1000;");

    if (obj1 == obj2) {
      System.out.println("The two objects are equal in memory.");
    }
    else {
      System.out.println("The two objects are NOT equal in memory.");
    }


    // Case II: obj1  = obj2 = 1000; 

    obj1 = obj2 = 1000;
    System.out.println("\nCase II: obj1 = obj2 = 1000;");

    if (obj1 == obj2) {
      System.out.println("The two objects are equal in memory.");
    }
    else {
      System.out.println("The two objects are NOT equal in memory.");
    }


    // Case III: obj1 = 100; obj2 = 100;

    obj1 = 100;
    obj2 = 100;
    System.out.println("\nCase III: obj1 = 100; obj2 = 100;");
    if (obj1 == obj2) {
      System.out.println("The two objects are equal in memory.");
    }
    else {
      System.out.println("The two objects are NOT equal in memory.");
    }


    // Case IV: obj1 = new Integer(100); obj2 = new Integer(100);

    obj1 = new Integer(100);
    obj2 = new Integer(100);
    System.out.println("\nCase IV: obj1 = new Integer(100); obj2 = new Integer(100);");
    if (obj1 == obj2) {
      System.out.println("The two objects are equal in memory.");
    }
    else {
      System.out.println("The two objects are NOT equal in memory.");
    }
  }
}

