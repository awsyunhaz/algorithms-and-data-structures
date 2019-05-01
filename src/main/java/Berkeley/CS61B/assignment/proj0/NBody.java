//package Berkeley.CS61B.assignment.proj0;

public class NBody {

    public static double readRadius(String fileName){
        In in = new In(fileName);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int N = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++){
            double xxPos = in.readDouble(), yyPos = in.readDouble(),
                    xxVel = in.readDouble(), yyVel = in.readDouble(),
                    mass = in.readDouble();
            String img = "images/" + in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]), dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        Planet[] planets = readPlanets(fileName);
        double radius = readRadius(fileName);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
//        StdAudio.play("audio/2001.mid");

        double time = 0;
        int n = planets.length;
        while (time < T){
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < n; i++){
                double xForce = planets[i].calcNetForceExertedByX(planets);
                double yForce = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForce, yForce);
                planets[i].draw();
            }
            StdDraw.show(10);
            time += dt;
        }
    }
}
