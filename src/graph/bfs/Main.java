package graph.bfs;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), res);
        return res;
    }

    public String traverse(TreeNode node, Map<String, Integer> cnt,
                           List<TreeNode> res) {
        if (node == null) {
            return "";
        }
        String representation = "(" + traverse(node.left, cnt, res) + ")" +
                node.val + "(" + traverse(node.right, cnt, res) +
                ")";
        cnt.put(representation, cnt.getOrDefault(representation, 0) + 1);
        if (cnt.get(representation) == 2) {
            res.add(node);
        }
        return representation;
    }
}

class Helper{
    TreeNode parent;
    int minRange;
    int maxRange;

    Helper(TreeNode parent, int minRange, int maxRange){
        this.parent = parent;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }
}


