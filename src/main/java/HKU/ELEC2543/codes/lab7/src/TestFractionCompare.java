public class TestFractionCompare {

  private static void compareAndPrint(Fraction f1, Fraction f2) {
    if (f1.compareTo(f2) < 0) 
      System.out.println(f1 + " is smaller than " + f2);
    else if (f1.compareTo(f2) == 0)
      System.out.println(f1 + " is the same as " + f2);
    else if (f1.compareTo(f2) > 0)
      System.out.println(f1 + " is larger than " + f2);
  }

  public static void main(String[] args) {
    Fraction f1, f2;

    f1 = new Fraction(2, 3);
    f2 = new Fraction(1, 3);
    compareAndPrint(f1, f2);

    f1 = new Fraction(10, 17);
    f2 = new Fraction(8, 13);
    compareAndPrint(f1, f2);

    f1 = new Fraction(11, 101);
    f2 = new Fraction(11, 101);
    compareAndPrint(f1, f2);
    
  }
}
