package graph;


import common.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {

    static ArrayList<Integer> preOrder = new ArrayList<>();
    static ArrayList<Integer> inOrder = new ArrayList<>();
    static ArrayList<Integer> postOrder = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        iterativeDFS(node1);
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }

    public static void iterativeDFS(TreeNode root){
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        while(!stack.isEmpty()){
            var pair = stack.peek();
            TreeNode node = pair.first;
            int val = pair.second;
            if (val == 1){
                preOrder.add(node.val);
                if (node.left != null)
                    stack.push(new Pair<>(node.left, 1));
                pair.second = 2;
            }else if (val == 2){
                inOrder.add(node.val);
                if (node.right != null)
                    stack.push(new Pair<>(node.right, 1));
                pair.second = 3;
            }else{
                postOrder.add(node.val);
                stack.pop();
            }
        }
    }
}
