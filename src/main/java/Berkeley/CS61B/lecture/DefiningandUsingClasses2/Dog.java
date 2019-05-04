package Berkeley.CS61B.lecture.DefiningandUsingClasses2;

public class Dog {
    public int weight;
    public static String scientificName = "Canis";

    public Dog(int w){
        weight = w;
    }

    public void makeNoise(){
        if (weight<10){
            System.out.println("yip!");
        }
        else if (weight<30){
            System.out.println("bark!");
        }
        else{
            System.out.println("Wooof!");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2){
        if (d1.weight > d2.weight){
            return d1;
        }
        else{
            return d2;
        }
    }

    public Dog maxDog(Dog d){
        if (this.weight > d.weight) {
            return this;
        }
        else {
            return d;
        }
    }

}
