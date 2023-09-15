package tree;


import java.util.Stack;

class BSTIterator{
    Stack<TreeNode> stack;
    boolean isReverse;

    BSTIterator(TreeNode root, boolean isReverse){
        stack = new Stack<>();
        this.isReverse = isReverse;
        pushAll(root);
    }

    int next(){
        TreeNode next = stack.pop();
        if(isReverse)
            pushAll(next.left);
        else
            pushAll(next.right);
        return next.val;
    }

    boolean hasNext(){
        return !stack.isEmpty();
    }

    void pushAll(TreeNode root){
        while(root != null){
            stack.push(root);
            root = isReverse ? root.right : root.left;
        }
    }
}