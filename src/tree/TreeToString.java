package tree;

public class TreeToString {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        r.left = n1;
        r.right = n2;
        n1.right = n3;
        System.out.println(tree2str(r));
    }

    public static String tree2str(TreeNode root) {
        return helper(root).toString();
    }

    static StringBuilder helper(TreeNode root){
        StringBuilder res = new StringBuilder();
        res.append(root.val);
        if(root.left != null) res.append("(").append(helper(root.left)).append(")");
        if(root.right != null) res.append("(").append(helper(root.right)).append(")");
        return res;
    }

}
