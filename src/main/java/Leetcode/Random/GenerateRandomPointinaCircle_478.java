package Leetcode.Random;

public class GenerateRandomPointinaCircle_478 {
    private double radius, x_center, y_center;

    public GenerateRandomPointinaCircle_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    // Rejection sampling - 215ms
    public double[] randPoint() {
        while (true){
            double x = Math.random()*radius*2-radius;
            double y = Math.random()*radius*2-radius;
            if (x*x+y*y < radius*radius)
                return new double[]{x_center+x, y_center+y};
        }
    }
}
