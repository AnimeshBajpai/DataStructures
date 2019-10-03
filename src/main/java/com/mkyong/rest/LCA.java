package com.mkyong.rest;


class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class LCA {
    static boolean isLeft = false, isRight = false;

    public Node findLCA(Node root, int a, int b) {

        if (root == null) {
            return null;
        }
        Node temp = null;
        if (root.data == a) {
            isLeft = true;
            return root;
        }
        if (root.data == b) {
            isRight = true;
            return root;
        }
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

//        if (temp != null) {
//            return temp;
//        }

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    // Finds the path from root node to given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false

    // Driver code
    public static void main(String[] args) {
        LCA tree = new LCA();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node result = tree.findLCA(root, 2, 10);
        if (isLeft && isRight) {
            System.out.println(result.data);
        } else {
            System.out.println("No LCA");
        }


    }
}
