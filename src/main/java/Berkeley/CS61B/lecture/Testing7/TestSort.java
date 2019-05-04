package Berkeley.CS61B.lecture.Testing7;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestSort {
    @Test
    public void testSort(){
        String[] input = {"beware", "of", "falling", "rocks"};
        String[] expected = {"beware", "falling", "of", "rocks"};
        Sort.sort(input);

        assertArrayEquals(input, expected);
//        for (int i = 0; i < expected.length; i++){
//            if (!input[i].equals(expected[i])){
//                System.out.println("Mismatch at position " + i + ", expected: '"
//                + expected[i] + "', but got: '" + input[i] + "'");
//                return;
//            }
//        }
    }

    @Test
    public void testFindSmallest(){
        String[] input = {"beware", "of", "falling", "rocks"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 1);

        assertEquals(expected, actual);
    }

    @Test
    public void testSwap(){
        String[] input = {"beware", "of", "falling", "rocks"};
        String[] expected = {"beware", "falling", "of", "rocks"};
        Sort.swap(input, 1, 2);

        assertArrayEquals(input, expected);
    }

//    public void static main(String[] args){
//        testSort();
//        testSwap();
//        testFindSmallest();
//    }

}
