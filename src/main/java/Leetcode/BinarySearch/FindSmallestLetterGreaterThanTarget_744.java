package Leetcode.BinarySearch;

public class FindSmallestLetterGreaterThanTarget_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length-1;
        while (lo < hi){
            int mid = (lo+hi)/2;
            if (letters[mid] <= target)
                lo = mid+1;
            if (letters[mid] > target)
                hi = mid;
        }
        return letters[lo] <= target? letters[0]: letters[lo];
    }
}
