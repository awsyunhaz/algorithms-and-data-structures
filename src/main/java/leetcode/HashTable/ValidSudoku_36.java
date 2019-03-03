package leetcode.HashTable;

import java.util.HashSet;
import java.util.Hashtable;

public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> subbox = new HashSet<>();
            for (int j = 0; j < 9; j++){
                if (board[i][j]!='.' && !row.add(board[i][j]))
                    return false;
                if (board[j][i]!='.' && !column.add(board[j][i]))
                    return false;
                int m = i/3*3 + j/3;
                int n = i%3*3 + j%3;
                if (board[m][n]!='.' && !subbox.add(board[m][n]))
                    return false;
            }
        }
        return true;
    }
}
