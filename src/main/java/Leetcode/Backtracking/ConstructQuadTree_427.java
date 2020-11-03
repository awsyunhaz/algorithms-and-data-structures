package Leetcode.Backtracking;

public class ConstructQuadTree_427 {
    /*
    Definition for a QuadTree node.
     */
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return construct(0, grid.length-1, 0, grid[0].length-1, grid);
    }

    public Node construct(int startRow, int endRow, int startCol, int endCol, int[][] grid) {
        Node node = new Node();
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (grid[i][j] != grid[startRow][startCol]) {
                    node.topLeft = construct(startRow, (startRow+endRow)/2, startCol, (startCol+endCol)/2, grid);
                    node.topRight = construct(startRow, (startRow+endRow)/2, (startCol+endCol)/2+1, endCol, grid);
                    node.bottomLeft = construct((startRow+endRow)/2+1, endRow, startCol, (startCol+endCol)/2, grid);
                    node.bottomRight = construct((startRow+endRow)/2+1, endRow, (startCol+endCol)/2+1, endCol, grid);
                    return node;
                }
            }
        }
        node.val = grid[startRow][startCol] == 1? true: false;
        node.isLeaf = true;
        return node;
    }
}
