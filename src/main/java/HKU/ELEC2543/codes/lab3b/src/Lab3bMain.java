public class Lab3bMain {

  public static void sameStringTest() {
    String s1, s2;
    
    s1 = "   This is a test!";
    s2 = "  This is a test!   ";

    if (Lab3bString.sameString(s1, s2))
      System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are the same.");
    else
      System.out.println("Your implementation is not correct!!!");
  }

  public static void sameStringIgnoreSpaceTest() {
    String s1, s2;

    s1 = "This     IS a TEST!";
    s2 = "   This is aTEST!    ";

    if (Lab3bString.sameStringIgnoreSpace(s1, s2))
      System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are the same.");
    else
      System.out.println("Your implementation is not correct!!!");
  }

  public static void countPatternTest() {
    String s1, s2;
    int count;

    s1 = "This is a test";
    s2 = "ok";
    count = Lab3bString.countPattern(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; count = " + count + "\t// correct answer: 0");

    s1 = "okThis is a test";
    s2 = "oK";
    count = Lab3bString.countPattern(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; count = " + count + "\t// correct answer: 1");

    s1 = "okThis is a testok";
    s2 = "OK";
    count = Lab3bString.countPattern(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; count = " + count + "\t// correct answer: 2");

    s1 = "okThis is OKate  ok st";
    s2 = "OK";
    count = Lab3bString.countPattern(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; count = " + count + "\t// correct answer: 3");
  }

  public static void removeTest() {
    String s1, s2;
    String result;
    
    s1 = "This is a test";
    s2 = "ok";
    result = Lab3bString.remove(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; result = " + result + "\t// correct answer: This is a test");

    s1 = "okThis is a teokst";
    s2 = "ok";
    result = Lab3bString.remove(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; result = " + result + "\t// correct answer: This is a test");

    s1 = "OkThis is a testok";
    s2 = "ok";
    result = Lab3bString.remove(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; result = " + result + "\t// correct answer: OkThis is a test");
  }

  public static void truncateTest() {
    String s1, s2, result;

    s1 = "This is a test";
    s2 = "ok";
    result = Lab3bString.truncate(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; result = " + result + "\t// correct answer: This is a test");

    s1 = "okThis is a test";
    s2 = "ok";
    result = Lab3bString.truncate(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; result = " + result + "\t// correct answer: <empty String>");

    s1 = "okThis is oka test";
    s2 = "ok";
    result = Lab3bString.truncate(s1, s2);
    System.out.println("s = \"" + s1 + "\"; pattern = \"" + s2 + "\"; result = " + result + "\t// correct answer: okThis is ");
  }

  public static void main(String[] args) {

    String s1, s2;

    System.out.println("sameString Test");
    sameStringTest();
    System.out.println();
    
    System.out.println("sameStringIgnoreSpace Test");
    sameStringIgnoreSpaceTest();
    System.out.println();

    System.out.println("countPattern Test");
    countPatternTest();
    System.out.println();
  
    System.out.println("remove Test");
    removeTest();
    System.out.println();
  
    System.out.println("truncate Test");
    truncateTest();
    System.out.println();
  }
}
