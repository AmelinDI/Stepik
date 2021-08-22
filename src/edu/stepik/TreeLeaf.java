package edu.stepik;

public class TreeLeaf {
    public static void main(String[] args) {

    }

    int treeLeafCount(Node root) {
        int result = 0;

        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        if (root.getLeft() != null){
            result = treeLeafCount(root.getLeft());
        }

        if (root.getRight() != null){
            result = result + treeLeafCount(root.getRight());
        }

        return result;
    }

    class Node {
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
