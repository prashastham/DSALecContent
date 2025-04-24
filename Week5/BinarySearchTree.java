import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    
    public class TreeNode{
        public int data;
        public TreeNode left, right, parent;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private TreeNode root;

    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        if(root == null){
            root = newNode;
        }
        else{
            TreeNode current = root;
            while (true) { 
                if(current.data > data){
                    if(current.left == null){
                        current.left = newNode;
                        newNode.parent = current;
                        break;
                    }
                    else{
                        current = current.left;
                    }
                }
                else if(current.data < data){
                    if(current.right == null){
                        current.right = newNode;
                        newNode.parent = current;
                        break;
                    }
                    else{
                        current = current.right;
                    }
                }
                else{
                    System.out.println("The value " + data + " already exists in the tree.");
                    break;
                }
            }
        }
    }

    // Traversals
    public void inOrderTraversal(TreeNode node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(TreeNode node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(TreeNode node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
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
    
    private static void fillLevels(TreeNode node, int level, int left, int right, List<List<String>> levels) {
        if (node == null) return;
        
        int mid = (left + right) / 2;
        levels.get(level).set(mid, String.valueOf(node.data));
        
        fillLevels(node.left, level + 1, left, mid - 1, levels);
        fillLevels(node.right, level + 1, mid + 1, right, levels);
    }
    

    // Get tree height
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // Print levels of nodes
    public static void printLevels(TreeNode root, int level) {
        if (root == null){}
        else{
            
            System.out.println("Node: " + root.data + " -> level: " + level);
        
            printLevels(root.left, level + 1);
            printLevels(root.right, level + 1);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        final int[] treeA = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 } ;
        final int[] treeB = { 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5 } ;
        final int[] treeC = { 30, 25, 20, 15, 10, 5, 35, 40, 45, 50, 55 } ;
        final int[] treeD = { 30, 15, 45, 10, 40, 20, 50, 5, 35, 25, 55 } ;
        
        for (int i = 0; i < treeA.length; i++) {
            tree.insert(treeD[i]);
        }

        System.out.println("Binary Search Tree:");
        printTree(tree.root);

        // System.out.println("\nIn-order traversal:");
        // tree.inOrderTraversal(tree.root);

        // System.out.println("\nPre-order traversal:");
        // tree.preOrderTraversal(tree.root);

        // System.out.println("\nPost-order traversal:");
        // tree.postOrderTraversal(tree.root);

        // System.out.println("\nHeigh of tree: " + getHeight(tree.root));

        printLevels(tree.root, 0);


    }

}