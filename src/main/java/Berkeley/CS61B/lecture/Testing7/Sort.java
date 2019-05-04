package Berkeley.CS61B.lecture.Testing7;

public class Sort {
    public static void sort(String[] strs){
        sort(strs, 0);
    }

    private static void sort(String[] strs, int start){
        if (start == strs.length)
            return;
        int smallestIndex = findSmallest(strs, start);
        swap(strs, start, smallestIndex);
        sort(strs, start + 1);
    }

    public static int findSmallest(String[] strs, int start){
        int smallestIndex = start;
        for (int i = start; i < strs.length; i++){
            if (strs[i].compareTo(strs[smallestIndex]) < 0)
                smallestIndex = i;
        }
        return smallestIndex;
    }

    public static void swap(String[] strs, int a, int b){
        String temp = strs[a];
        strs[a] = strs[b];
        strs[b] = temp;
    }

}
