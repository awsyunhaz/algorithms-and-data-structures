package Berkeley.CS61B.lecture.InheritanceImplements8;

public class WordUtils {
    public static String longest(List61B<String> list){
        int longestIndex = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).length() > longestIndex)
                longestIndex = i;
        }
        return list.get(longestIndex);
    }

    public static void main(String[] args){
        AList<String> list = new AList<>();
        list.addLast("dog");
        list.addLast("cat");
        list.addLast("Elephant");
        System.out.println(longest(list));
    }
}
