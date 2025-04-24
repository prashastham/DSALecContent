import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTree {
    public class AVLTreeNode {
        final private int data;
        private AVLTreeNode left;
        private AVLTreeNode right;
        private int height;

        public AVLTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    AVLTreeNode root;

    public AVLTree() {
        root = null;
    }

    // Get tree height
    public static int getHeight(AVLTreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // Insert a node into the AVL tree
    public AVLTreeNode insert(AVLTreeNode node, int data) {
        if (node == null) {
            return new AVLTreeNode(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate keys are not allowed in AVL tree
            return node;
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        // Left-Left case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        // Right-Right case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        // Left-Right case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right-Left case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // Get balance factor of a node
    public int getBalance(AVLTreeNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // Left rotate a subtree
    public AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    // Right rotate a subtree
    public AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    // Print tree utility functions
    private static void fillLevels(AVLTreeNode node, int level, int left, int right, List<List<String>> levels) {
        if (node == null) return;
        
        int mid = (left + right) / 2;
        levels.get(level).set(mid, String.valueOf(node.data));
        
        fillLevels(node.left, level + 1, left, mid - 1, levels);
        fillLevels(node.right, level + 1, mid + 1, right, levels);
    }

    public static void printTree(AVLTreeNode root) {
        if (root == null) return;
        
        Queue<AVLTreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int maxLevel = getHeight(root);
        int width = (int) Math.pow(2, maxLevel) - 1;
        
        List<List<String>> levels = new ArrayList<>();
        
        for (int i = 0; i < maxLevel; i++) {
            levels.add(new ArrayList<>(Collections.nCopies(width, " ")));
        }
        
        fillLevels(root, 0, 0, width - 1, levels);
        
        for (List<String> level : levels) {
            System.out.println(String.join("", level));
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        final int[] treeA = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 } ;
        final int[] treeB = { 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5 } ;
        final int[] treeC = { 30, 25, 20, 15, 10, 5, 35, 40, 45, 50, 55 } ;
        final int[] treeD = { 30, 15, 45, 10, 40, 20, 50, 5, 35, 25, 55 } ;
        
        for(int i : treeC) {
            tree.root = tree.insert(tree.root, i);
        }

        System.out.println("Binary Search Tree:");
        printTree(tree.root);
    }
}
