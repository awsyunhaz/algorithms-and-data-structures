package Leetcode.BinarySearch;

public class SearchInASortedArrayOfUnknownSize_702 {

    class ArrayReader {
        public int get(int index) {
            return 0;
        }
    }

    public int search(ArrayReader reader, int target) {
        int size = 1;
        while (reader.get(size-1) < target) {
            size *= 2;
        }
        int lo = size / 2, hi = size;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
