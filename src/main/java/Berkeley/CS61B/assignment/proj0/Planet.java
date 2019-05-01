//package Berkeley.CS61B.assignment.proj0;

public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) +
                (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        double dis = calcDistance(p);
        return 6.67e-11 * mass * p.mass / (dis * dis);
    }

    public double calcForceExertedByX(Planet p){
        double dis = calcDistance(p), disX = p.xxPos - xxPos;
        return calcForceExertedBy(p) / dis * disX;
    }

    public double calcForceExertedByY(Planet p){
        double dis = calcDistance(p), disY = p.yyPos - yyPos;
        return calcForceExertedBy(p) / dis * disY;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double forceX = 0;
        for (Planet p: allPlanets){
            if (p.equals(this)) {
                continue;
            }
            forceX += calcForceExertedByX(p);
        }
        return forceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double forceY = 0;
        for (Planet p: allPlanets){
            if (p.equals(this)) {
                continue;
            }
            forceY += calcForceExertedByY(p);
        }
        return forceY;
    }

    public void update(double dt, double fX, double fY){
        xxVel += fX / mass * dt;
        yyVel += fY / mass * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, imgFileName);
    }

}
