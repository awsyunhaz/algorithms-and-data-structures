//package Berkeley.CS61B.assignment.proj0;

public class TestPlanet {
    public static void main(String[] args){
        checkCalcForce();
    }

    public static void checkCalcForce(){
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(-1.0, 1.0, 0.0, 4.0, 10.0, "jupiter.gif");
        System.out.println(p1.calcForceExertedByX(p2));
    }
}
