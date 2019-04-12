public class CheckDriver {

  public static void main(String[] args) {
    Check c1, c2, c3;

    // new Check(name, amount); creates a new check
    // name is the payee of the check
    // amount is the cash value of the check
    c1 = new Check("Peter Pan", 100);
    c2 = new Check("Wendy", 200);
    c3 = new Check("TinkerBell", 600);

    System.out.println("c1 = " + c1);
    System.out.println("c2 = " + c2);
    System.out.println("c3 = " + c3);
  }
}
