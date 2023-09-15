package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ConstructFromInorderAndLevelOrder {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(30);
        TreeNode n5 = new TreeNode(11);
        TreeNode n6 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;

//        Arrays.cop

        TreeNode ans = build(new int[]{30, 5, 11, 10, 3, 4}, new int[]{10, 5, 3, 30, 11, 4}, 0, 5);
    }

//            10(0)
//        5(1)       3(2)
//
//       30     11(4)        4(6)

    //   30  5, 11, 10, 3, 4   inorder

    //  10, 5, 3, 30, 11, 4   levelOrder

    static TreeNode build(int[] indOrder, int[] levelOrder, int sInorder, int eInorder){

        if (sInorder > eInorder)
            return null;

        TreeNode root = new TreeNode(levelOrder[0]);
        int rIndex = find(indOrder, root.val, sInorder, eInorder);

        Set<Integer> set = new HashSet<>();

        for (int i = sInorder; i <= rIndex - 1 ; i++) {
            set.add(indOrder[i]);
        }

        ArrayList<Integer> leftLevelOrder = new ArrayList<>();

        for (int j = 1; j < levelOrder.length; j++) {
            if (set.contains(levelOrder[j])){
                leftLevelOrder.add(levelOrder[j]);
            }
        }

        ArrayList<Integer> rightLevelOrder = new ArrayList<>();

        for (int j = 1; j < levelOrder.length; j++) {
            if (!set.contains(levelOrder[j])){
                rightLevelOrder.add(levelOrder[j]);
            }
        }

        root.left = build(indOrder, leftLevelOrder.stream().mapToInt(Integer::intValue).toArray(), sInorder, rIndex - 1);
        root.right = build(indOrder, rightLevelOrder.stream().mapToInt(Integer::intValue).toArray(), rIndex + 1, eInorder);


        return root;


    }

    static int find(int[] inOrder, int root, int s, int e){
        for (int i = s; i <= e; i++) {
            if (inOrder[i] == root)
                return i;
        }
        return -1;
    }

}
