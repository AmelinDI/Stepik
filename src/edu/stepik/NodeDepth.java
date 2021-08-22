package edu.stepik;

import java.util.Stack;

public class NodeDepth {
    public static void main(String[] args) {

    }

    int treeDepth(Node root) {
        int depthLeft = (root.getLeft() != null) ? treeDepth(root.getLeft()) : 0;
        int depthRight = (root.getRight() != null) ? treeDepth(root.getRight()) : 0;

        int result = (depthLeft > depthRight) ? depthLeft : depthRight;

        return result + 1;
    }

    static class Node {
        private Node left;
        private Node right;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}


        /*if (root.getLeft() != null){
                depthLeft = treeDepth(root.getLeft());
                }

                if (root.getRight() != null){
                depthRight = treeDepth(root.getRight());
                }
        */


/*
    Stack<Node> stack = new Stack<>();

        while (root.getLeft() != null || root.getRight() != null){
                if (root.getLeft() != null){
                stack.push(root.getLeft());
                }
                if (root.getRight() != null){
                stack.push(root.getRight());
                }
                stack.
                root = stack.pop();
                }
*/
