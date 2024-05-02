import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void inorder()  { inorderRec(root); }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() { preorderRec(root); }
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() { postorderRec(root); }
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    boolean search(int key) {
        return searchRec(root, key) != null;
    }

    Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key > key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }
}


public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert nodes
        bst.insert(20);
        bst.insert(15);
        bst.insert(30);
        bst.insert(9);
        bst.insert(12);
        bst.insert(25);
        
        // Insert new node 45
        bst.insert(45);
        
        // Delete nodes
        bst.deleteKey(15);
        bst.deleteKey(25);
        
        // Traversals
        System.out.println("Inorder traversal:");
        bst.inorder();
        System.out.println("\nPreorder traversal:");
        bst.preorder();
        System.out.println("\nPostorder traversal:");
        bst.postorder();
        
        // Search
        boolean found = bst.search(9);
        //System.out.println("\nSearch for node 9: " + (found ? "Found" : "Not Found"));
        
        System.out.print("\nSearch for node 9: ");
        if (found) {
          System.out.println("Found");
        } else {
          System.out.println("Not Found");
        }
    }
}
