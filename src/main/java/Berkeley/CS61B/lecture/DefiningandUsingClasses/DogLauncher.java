package Berkeley.CS61B.lecture.DefiningandUsingClasses;

public class DogLauncher {
    public static void main(String[] args){
        Dog d1 = new Dog(10);
        Dog d2 = new Dog(100);

//        Dog biggerDog = Dog.maxDog(d1, d2);
//        biggerDog.makeNoise();
        Dog biggerDog = d1.maxDog(d2);
        biggerDog.makeNoise();

        System.out.println(Dog.scientificName);
    }
}
