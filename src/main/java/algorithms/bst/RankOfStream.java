package algorithms.bst;

public class RankOfStream {
    class TreeNode {
        int val, count;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            count = 1;
        }
    }

    private TreeNode root;

    public RankOfStream() {
        root = null;
    }

    public void track (int num) {
        root = addNum(root, num);
    }

    public TreeNode addNum(TreeNode node, int num) {
        if (node == null) {
            return new TreeNode(num);
        } else {
            if (node.val == num) {
                node.count ++;
            } else if (num < node.val) {
                node.left = addNum(node.left, num);
            } else {
                node.right = addNum(node.right, num);
            }
            return node;
        }
    }

    public int getRank(int num) {
        return traverse(root, num);
    }

    public int traverse(TreeNode root, int num) {
        if (root == null) {
            return 0;
        } else {
            if (num <= root.val) {
                return traverse(root.left, num);
            } else {
                return root.count + traverse(root.left, num) + traverse(root.right, num);
            }
        }
    }

    public static void main(String args[]) {
        RankOfStream ros = new RankOfStream();
        int[] nums = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
        for (int num: nums) {
            ros.track(num);
        }
        System.out.println(ros.getRank(4));
    }
}
