package tree;

public class IsIsomorphicTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        root1.left = n1;
        root1.right = n2;
        n1.left = n3;

        TreeNode root2 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        root2.left = n5;
        root2.right = n4;
        n4.right = n6;

        System.out.println(isIsomorphic(root1, root2));
    }

    static boolean isIsomorphic(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        if(root1 != null && root2 != null && root1.val != root2.val) return false;

        if (root1 == null || root2 == null) return false;

        return isIsomorphic(root1.left, root2.left)
                || isIsomorphic(root1.left, root2.right)
                || isIsomorphic(root1.right, root2.left)
                || isIsomorphic(root1.right, root2.right);
    }

}
