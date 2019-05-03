//package Berkeley.CS61B.exercise.list1;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if (rest == null)
            return 1;
        return rest.size() + 1;
    }

    public int iterativeSize(){
        int size = 0;
        IntList l = this;
        while (l != null) {
            size++;
            l = l.rest;
        }
        return size;
    }

    public int get(int i){
//        IntList l = this;
//        for (; i > 0; i--){
//            l = l.rest;
//        }
//        return l.first;
        if (i == 0)
            return first;
        return rest.get(i-1);
    }

    public static void main(String[] args){
        IntList l = new IntList(15, null);
        l = new IntList(10, l);
        l = new IntList(5, l);
        System.out.println(l.size());
        System.out.println(l.iterativeSize());
        System.out.println(l.get(2));
    }
}
