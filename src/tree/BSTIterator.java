package tree;


import java.util.Stack;

class BSTIterator{
    Stack<Node> stack;
    boolean isReverse;

    BSTIterator(Node root, boolean isReverse){
        stack = new Stack<>();
        this.isReverse = isReverse;
        pushAll(root);
    }

    int next(){
        Node next = stack.pop();
        if(isReverse)
            pushAll(next.left);
        else
            pushAll(next.right);
        return next.val;
    }

    boolean hasNext(){
        return !stack.isEmpty();
    }

    void pushAll(Node root){
        while(root != null){
            stack.push(root);
            root = isReverse ? root.right : root.left;
        }
    }
}