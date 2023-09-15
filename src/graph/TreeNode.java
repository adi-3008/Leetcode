package graph;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    int val;

    public TreeNode(int data) {
        this.val = data;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
