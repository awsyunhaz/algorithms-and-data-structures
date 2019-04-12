public class TestFraction2 {
  public static void main(String[] args) {
    Fraction2 f1, f2;  

    f1 = new Fraction2(3, -4); 
    f2 = f1.inverse();
    System.out.println("f2 is the inverse of f1.....");
    System.out.println("f1 = " + f1 + "\t// Correct answer: -3/4");
    System.out.println("f2 = " + f2 + "\t// Correct answer: -4/3");

    f2.square();
    System.out.println("After squaring f2.....");
    System.out.println("f1 = " + f1 + "\t// Correct answer: -3/4");
    System.out.println("f2 = " + f2 + "\t// Correct answer: 16/9");

    f1 = f2.copy();
    System.out.println("f1 is now a copy of f2.....");
    System.out.println("f1 = " + f1 + "\t// Correct answer: 16/9");
    System.out.println("f2 = " + f2 + "\t// Correct answer: 16/9");

  }
}
